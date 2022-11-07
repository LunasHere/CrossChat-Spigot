package com.lunashere.crosschat.crosschat;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    // LuckPerms API
    public static LuckPerms luckPerms;

    public static String serverName;

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
            luckPerms = api;
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
