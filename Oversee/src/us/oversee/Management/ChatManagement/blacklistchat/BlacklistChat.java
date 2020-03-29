package us.oversee.Management.ChatManagement.blacklistchat;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import us.oversee.Oversee;
import us.oversee.files.Lang;
import us.oversee.files.Settings;
import us.oversee.utillities.Cooldown;
import us.oversee.utillities.utils;

public class BlacklistChat implements Listener {

	public static String prefix = utils.translate("&b&lBlacklistChat &8&l» &7");

	public static HashMap<UUID, Boolean> choosingDelay = new HashMap<UUID, Boolean>();

	public static Oversee plugin;

	public BlacklistChat(Oversee plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void delayChat(AsyncPlayerChatEvent e) {

		Player p = (Player) e.getPlayer();
		String msg = e.getMessage();

		if (Settings.settings.getBoolean("Blacklist.Enabled") == true) {

			if (choosingDelay.containsKey(p.getUniqueId())) {

				Player target = Bukkit.getPlayer(e.getMessage());
				
				if (target ==null) {
					p.sendMessage(utils.translate(prefix + "Please enter a valid username!"));

					e.setCancelled(true);

				
				} else {

					p.sendMessage(utils.translate(prefix + "You have delayed chat " + msg + "s."));
					Settings.settings.set("Blacklist.Enabled", true);


					Settings.saveSettings();

					choosingDelay.remove(p.getUniqueId());
					e.setCancelled(true);
					return;

				}

				if ((Settings.settings.getBoolean("Blacklist.Enabled") == false)) {
					p.sendMessage(utils
							.translate(prefix + "This feature is currently disabled, enable it in the config.yml."));
					return;
				}

				if (!(choosingDelay.containsKey(p.getUniqueId()))) {

				}
			}
		}

	}

	@EventHandler
	public void onBlacklist(AsyncPlayerChatEvent e) {

		if (Settings.settings.getBoolean("Blacklist.Enabled") == true) {

			Player p = (Player) e.getPlayer();

			UUID uuid = p.getUniqueId();
			String CDname = "Delay";

			int delay;

			delay = Integer.parseInt(plugin.getConfig().getString("Blacklist.Delay"));

			Cooldown cd = new Cooldown(uuid, CDname, delay);

			if (!(Cooldown.isInCooldown(p.getUniqueId(), CDname))) {
				cd.start();
				return;

			} else {

				if (p.hasPermission("oversee.bypassBlacklist") || p.isOp()) {
					return;

				} else if (!(p.hasPermission("oversee.bypassBlacklist")))
					e.setCancelled(true);

				String CFGString = utils.translate(Lang.Lang.getString("Blacklist-Cooldown"));

				p.sendMessage(utils.translate(CFGString).replaceAll("%delay%",
						Integer.toString(cd.getTimeLeft(uuid, CDname))));
				return;
			}

		}
	}

	public void onLeave(Player p) {

		if (choosingDelay.containsKey(p.getUniqueId())) {

			choosingDelay.remove(p.getUniqueId());
			return;

		} else if (!(choosingDelay.containsKey(p.getUniqueId()))) {
			return;
		}
	}

}
