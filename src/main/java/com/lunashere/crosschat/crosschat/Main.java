package com.lunashere.crosschat.crosschat;

import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register outgoing channel
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        // Register the channel listener
        getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new ChannelListener());
        // Register the player chat listener
        getServer().getPluginManager().registerEvents(new PlayerChat(), this);
        // Register Luckperms API
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            LuckPerms api = provider.getProvider();

        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
