package dev.mnyacat.toolbox.listeners;

import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import dev.mnyacat.toolbox.Utils;
import dev.mnyacat.toolbox.items.Elixir;

public class ElixirInteractListener implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = event.getPlayer().getInventory().getItemInMainHand();
        if ((event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)
                && mainHandItem.isSimilar(Elixir.createItemStack())) {
            event.setCancelled(true);
            boolean isSneaking = player.isSneaking();
            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            player.setFoodLevel(100);
            player.setSaturation(100);
            if (isSneaking) {
                player.sendMessage("体力と満腹度を回復しました");
            } else {
                Utils.removeHarmfulPotionEffects(player);
                player.sendMessage("体力と満腹度を回復し、ネガティブなエフェクトを解除しました");
            }
            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 2);
        }
    }
}
