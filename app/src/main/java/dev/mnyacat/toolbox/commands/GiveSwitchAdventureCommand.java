package dev.mnyacat.toolbox.commands;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import dev.mnyacat.toolbox.ToolBoxPlugin;
import dev.mnyacat.toolbox.items.SwitchAdventure;

public class GiveSwitchAdventureCommand extends ToolBoxBaseCommand {

    public GiveSwitchAdventureCommand(@NotNull ToolBoxPlugin plugin, @NotNull String name, @NotNull String description,
            @NotNull String usageMessage, @NotNull List<String> aliases) {
        super(plugin, name, description, usageMessage, aliases);
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.getInventory().addItem(SwitchAdventure.createItemStack());
            return true;
        }
        return false;
    }

}
