package dev.mnyacat.toolbox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Registry;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class Utils {
    public static List<PotionEffectType> getPotionEffectTypeByCategory(PotionEffectType.Category category) {
        List<PotionEffectType> effects = new ArrayList<PotionEffectType>();
        for (Iterator<PotionEffectType> itr = Registry.EFFECT.iterator(); itr.hasNext();) {
            PotionEffectType effect = itr.next();
            if (effect.getEffectCategory() == PotionEffectType.Category.HARMFUL) {
                effects.add(effect);
            }
        }
        return effects;
    }

    public static void removeHarmfulPotionEffects(Player player) {
        List<PotionEffectType> negativeEffects = getPotionEffectTypeByCategory(PotionEffectType.Category.HARMFUL);
        for (PotionEffectType negativeEffect : negativeEffects) {
            if (player.hasPotionEffect(negativeEffect)) {
                player.removePotionEffect(negativeEffect);
            }
        }
    }
}
