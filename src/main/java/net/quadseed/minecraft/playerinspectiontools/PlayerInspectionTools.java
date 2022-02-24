package net.quadseed.minecraft.playerinspectiontools;

import net.quadseed.minecraft.playerinspectiontools.commands.InspectorCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerInspectionTools extends JavaPlugin {

    private static PlayerInspectionTools plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getCommand("inspector").setExecutor(new InspectorCommand());

        getServer().getPluginManager().registerEvents(new PlayerActionListener(), this);
    }

    public static PlayerInspectionTools getPlugin() {
        return plugin;
    }
}
