package dev.mnyacat.toolbox.listeners;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import dev.mnyacat.toolbox.items.SwitchAdventure;

public class SwitchAdventureInteractListener implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = event.getPlayer().getInventory().getItemInMainHand();
        if ((event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)
                && mainHandItem.isSimilar(SwitchAdventure.createItemStack())) {
            event.setCancelled(true);
            GameMode currentGameMode = player.getGameMode();
            switch (currentGameMode) {
                case SURVIVAL:
                case ADVENTURE: {
                    player.setGameMode(GameMode.CREATIVE);
                    break;
                }
                case CREATIVE: {
                    player.setGameMode(GameMode.ADVENTURE);
                    break;
                }
                default: {
                    player.setGameMode(GameMode.CREATIVE);
                    break;
                }
            }
            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 2);
        }
    }
}
