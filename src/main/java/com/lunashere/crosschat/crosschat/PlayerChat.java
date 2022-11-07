package com.lunashere.crosschat.crosschat;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.luckperms.api.model.user.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import static com.lunashere.crosschat.crosschat.Main.luckPerms;

public class PlayerChat implements Listener {
    @EventHandler
    public void onPlayerChat(PlayerChatEvent e) {

        Main.setCurrentServer();

        User user = luckPerms.getUserManager().getUser(e.getPlayer().getUniqueId());
        String prefix = user.getCachedData().getMetaData().getPrefix();

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Forward");
        out.writeUTF("ALL");
        out.writeUTF("CrossChat");

        ByteArrayOutputStream msgbytes = new ByteArrayOutputStream();
        DataOutputStream msgout = new DataOutputStream(msgbytes);
        try {
            msgout.writeUTF("[" + Main.serverName + "] " + prefix + e.getPlayer().getName() + ": " + e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        out.writeShort(msgbytes.toByteArray().length);
        out.write(msgbytes.toByteArray());

        e.getPlayer().sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", out.toByteArray());
    }

}
