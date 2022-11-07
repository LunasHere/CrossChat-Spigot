package com.lunashere.crosschat.crosschat;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class ChannelListener implements PluginMessageListener {

    @Override
    public synchronized void onPluginMessageReceived(String channel, Player player, byte[] message) {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
        try {
            String subchannel = in.readUTF();
            if (subchannel.equals("CrossChat")) {
                short len = in.readShort();
                byte[] msgbytes = new byte[len];
                in.readFully(msgbytes);

                DataInputStream msgin = new DataInputStream(new ByteArrayInputStream(msgbytes));
                String msg = msgin.readUTF();
                for (Player p : player.getServer().getOnlinePlayers()) {
                    p.sendMessage(msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
