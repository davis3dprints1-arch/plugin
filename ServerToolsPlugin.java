package com.servertoolsplugin;

import com.servertoolsplugin.anticheat.FlagManager;
import com.servertoolsplugin.anticheat.FlyListener;
import com.servertoolsplugin.anticheat.OreListener;
import com.servertoolsplugin.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerToolsPlugin extends JavaPlugin {

    private FlagManager flagManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        // Anti-cheat
        this.flagManager = new FlagManager(this);
        getServer().getPluginManager().registerEvents(new OreListener(this), this);
        getServer().getPluginManager().registerEvents(new FlyListener(this), this);

        // Commands
        getCommand("wipe").setExecutor(new WipeCommand(this));
        getCommand("offend").setExecutor(new OffendCommand(this));
        getCommand("unban").setExecutor(new UnbanCommand(this));
        getCommand("flags").setExecutor(new FlagsCommand(this));
        getCommand("clearflags").setExecutor(new ClearFlagsCommand(this));

        getLogger().info("ServerToolsPlugin enabled — Wipe, Offend, Unban, AntiCheat loaded.");
    }

    @Override
    public void onDisable() {
        getLogger().info("ServerToolsPlugin disabled.");
    }

    public FlagManager getFlagManager() {
        return flagManager;
    }
}
