package dev.mnyacat.toolbox.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.jetbrains.annotations.NotNull;

import dev.mnyacat.toolbox.ToolBoxPlugin;

public abstract class ToolBoxBaseCommand extends Command {
    public ToolBoxBaseCommand(@NotNull ToolBoxPlugin plugin, @NotNull String name, @NotNull String description,
            @NotNull String usageMessage, @NotNull List<String> aliases) {
        super(name, description, usageMessage, aliases);
        this.plugin = plugin;
    }

    protected ToolBoxPlugin plugin;
}
