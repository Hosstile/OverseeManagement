package us.oversee.events;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import us.oversee.Management.ChatManagement.staffchat.StaffChat;
import us.oversee.files.Lang;
import us.oversee.utillities.utils;

public class StaffChatEvent implements Listener {

	public static HashMap<UUID, Player> ignoreStaffChat = new HashMap<UUID, Player>();

	@EventHandler
	public void onStaff(AsyncPlayerChatEvent e) {

		for (Player all : Bukkit.getOnlinePlayers()) {

			if (!(all.isOp()) || all.hasPermission("oversee.staffchat")) {

				return;

			} else if((all.isOp()) || all.hasPermission("oversee.staffchat")) {
				
				e.setCancelled(true);
				
				 all.sendMessage(utils.translate(Lang.Lang.getString("StaffChat-Format"))
				 .replaceAll("%sender%", e.getPlayer().getName()).replaceAll("%message%",
				 e.getMessage()));
				 return;
				
			}

		}

	

	}
}
