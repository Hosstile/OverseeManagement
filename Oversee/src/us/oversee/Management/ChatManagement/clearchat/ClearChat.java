package us.oversee.Management.ChatManagement.clearchat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import us.oversee.Oversee;
import us.oversee.files.Lang;
import us.oversee.utillities.utils;

public class ClearChat {

	private static ClearChat clearchat;

	public static ClearChat getClearChat() {
		return clearchat;
	}

	public static Oversee plugin;

	public ClearChat(Oversee plugin) {
		this.plugin = plugin;
	}

	public static void clearChat(Player p) {

	
		for(Player all : Bukkit.getOnlinePlayers()) {
			
			if(!(all.hasPermission("oversee.bypassclearchat"))) {
			
			for(int i = 0; i < 250; i++) {
				
				all.sendMessage(" ");

				
			}
			
			all.sendMessage(utils.translate(Lang.Lang.getString("Chat-Cleared")).replaceAll("%player%", p.getName()));
			
			}
		
		}
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			
			if((all.hasPermission("oversee.bypassclearchat"))) {
				all.sendMessage(utils.translate(Lang.Lang.getString("BypassClearChat")));
				return;
			}
			
		}

	}
	
}