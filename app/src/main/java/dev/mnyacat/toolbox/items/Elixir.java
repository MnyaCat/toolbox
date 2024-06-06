package dev.mnyacat.toolbox.items;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class Elixir {
    public static ItemStack createItemStack() {
        ItemStack item = new ItemStack(Material.LINGERING_POTION);
        PotionMeta potionMeta = (PotionMeta) item.getItemMeta();
        potionMeta.setColor(Color.FUCHSIA);
        item.setItemMeta(potionMeta);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.displayName(Component.text("Elixir").color(NamedTextColor.LIGHT_PURPLE));
        item.setItemMeta(itemMeta);
        return item;
    }
}
