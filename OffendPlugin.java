package com.offendplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class OffendPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("offend").setExecutor(new OffendCommand(this));
        getLogger().info("OffendPlugin enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("OffendPlugin disabled.");
    }
}
