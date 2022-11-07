package com.lunashere.crosschat.crosschat;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerConnect implements Listener {

    @EventHandler
    public void onPlayerConnect(PlayerJoinEvent e) {
        // Get the server name
        if(Main.serverName == null) {
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("GetServer");
            e.getPlayer().sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", out.toByteArray());
        }
    }
}
