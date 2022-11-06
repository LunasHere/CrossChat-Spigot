package com.lunashere.crosschat.crosschat;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register the channel listener
        getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new ChannelListener());
        // Register the player chat listener
        getServer().getPluginManager().registerEvents(new PlayerChat(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
