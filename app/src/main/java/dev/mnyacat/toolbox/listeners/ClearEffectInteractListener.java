package dev.mnyacat.toolbox.listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import dev.mnyacat.toolbox.Utils;
import dev.mnyacat.toolbox.items.ClearEffect;

public class ClearEffectInteractListener implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = event.getPlayer().getInventory().getItemInMainHand();
        if ((event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)
                && mainHandItem.isSimilar(ClearEffect.createItemStack())) {
            event.setCancelled(true);
            boolean isSneaking = player.isSneaking();
            if (isSneaking) {
                Utils.removeHarmfulPotionEffects(player);
                player.sendMessage("ネガティブなエフェクトを解除しました");
            } else {
                player.clearActivePotionEffects();
                player.sendMessage("全てのエフェクトを解除しました");
            }
            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 2);
        }
    }
}
