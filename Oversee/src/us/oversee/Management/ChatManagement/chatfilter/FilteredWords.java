package us.oversee.Management.ChatManagement.chatfilter;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import us.oversee.Oversee;
import us.oversee.files.Lang;
import us.oversee.utillities.utils;

public class FilteredWords implements Listener {

	public static ArrayList<String> filter = new ArrayList<String>();
	
	public static Oversee plugin;

	public FilteredWords(Oversee plugin) {
		this.plugin = plugin;
	}

	public static List<String> getblockedWords() {

		return plugin.getConfig().getStringList("Blocked-Words");

	}

	@EventHandler

	public void onFilterChat(AsyncPlayerChatEvent e) {

		if (plugin.getConfig().getBoolean("Chat-Filter") == false) {
			return;
		}
		
		String message = e.getMessage().toLowerCase();

		if (plugin.getConfig().getBoolean("Chat-Filter") == true) {

			for(String blocked : plugin.getConfig().getStringList("Blocked-Words")) {
				
				if(message.equals(blocked.toLowerCase())) {
					e.getPlayer().sendMessage(utils.translate(Lang.Lang.getString("FilterBlocked")));
					e.setCancelled(true); return;
					
					
				}
				
			}
			

		}
	}

}
