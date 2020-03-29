package us.oversee.events;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import us.oversee.Oversee;
import us.oversee.interfaces.Messages;
import us.oversee.utillities.utils;

public class FilterBlock implements Listener {

	public Oversee plugin;

	 public FilterBlock(Oversee plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onJoin(AsyncPlayerChatEvent e) {

		Player p = (Player) e.getPlayer();

		List<String> swearWords = plugin.getConfig().getStringList("Blocked-Words");
		List<String> containable = plugin.getConfig().getStringList("Containable-Blocked-Words");


		for (String s : swearWords) {

			if (e.getMessage().contains(s)) {

				e.getPlayer()
						.sendMessage(utils.translate(Messages.prefix + "&cPlease don't swear &4&l" + e.getPlayer().getName()));

				e.setCancelled(true);

				return;
			}else {
				
               
				
				
			}
		}
	}

}
