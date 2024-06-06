package dev.mnyacat.toolbox;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dev.mnyacat.toolbox.commands.GiveBasicCommand;
import dev.mnyacat.toolbox.commands.GiveClearEffectCommand;
import dev.mnyacat.toolbox.commands.GiveElixirCommand;
import dev.mnyacat.toolbox.commands.GiveSwitchAdventureCommand;
import dev.mnyacat.toolbox.commands.GiveSwitchSurvivalCommand;
import dev.mnyacat.toolbox.listeners.ClearEffectInteractListener;
import dev.mnyacat.toolbox.listeners.ElixirInteractListener;
import dev.mnyacat.toolbox.listeners.SwitchAdventureInteractListener;
import dev.mnyacat.toolbox.listeners.SwitchSurvivalInteractListener;

public class ToolBoxPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new ClearEffectInteractListener(), this);
        manager.registerEvents(new ElixirInteractListener(), this);
        manager.registerEvents(new SwitchAdventureInteractListener(), this);
        manager.registerEvents(new SwitchSurvivalInteractListener(), this);

        CommandMap commandMap = Bukkit.getServer().getCommandMap();
        commandMap.register("",
                new GiveBasicCommand(this, "givebasic", "ワールド製作に必要なアイテムを付与します",
                        "/<command>",
                        List.of("gb")));
        commandMap.register("",
                new GiveClearEffectCommand(this, "givecleareffect", "全てのエフェクトを解除するアイテムを付与します",
                        "/<command>",
                        List.of("gc")));
        commandMap.register("",
                new GiveElixirCommand(this, "giveelixir", "体力と満腹度を全回復させ、デバフを解除するアイテムを付与します",
                        "/<command>",
                        List.of("ge")));
        commandMap.register("",
                new GiveSwitchAdventureCommand(this, "giveswitchadventure", "クリエイティブモードとアドベンチャーモードを切り替えるアイテムを付与します",
                        "/<command>",
                        List.of("ga")));
        commandMap.register("",
                new GiveSwitchSurvivalCommand(this, "giveswitchsurvival", "クリエイティブモードとサバイバルモードを切り替えるアイテムを付与します",
                        "/<command>",
                        List.of("gs")));

    }
}
