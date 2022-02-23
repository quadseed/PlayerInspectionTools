package net.quadseed.minecraft.playerinspectiontools;

import net.quadseed.minecraft.playerinspectiontools.commands.InspectorCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerInspectionTools extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("inspector").setExecutor(new InspectorCommand());
    }
}
