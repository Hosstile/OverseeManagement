package us.oversee.Management.PlayerManagement.kick;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import us.oversee.Oversee;
import us.oversee.files.Lang;
import us.oversee.files.PlayerData;
import us.oversee.files.Settings;
import us.oversee.utillities.utils;

public class Kick implements Listener {

	public static Oversee plugin;

	public Kick(Oversee plugin) {
		this.plugin = plugin;
	}

	public static HashMap<UUID, Boolean> choosenTarget = new HashMap<UUID, Boolean>();
	public static HashMap<UUID, Boolean> choosingTarget = new HashMap<UUID, Boolean>();
	public static HashMap<UUID, Boolean> choosingReason = new HashMap<UUID, Boolean>();

	public static void kickPlayer(Player kicker, Player kicked, String reason) {

		if (kicker.hasPermission("oversee.kick") && Settings.settings.getBoolean("Kick.Notify") == false) {

			kicked.kickPlayer(utils.translate(Lang.Lang.getString("Kick-Layout").replaceAll("%reason%", reason).replaceAll("%kicked%", kicked.getName()).replaceAll("%kicker%", kicker.getName())));
			
			return;

		}

		if (Settings.settings.getBoolean("Kick.Notify") == true) {

			if (kicker.hasPermission("oversee.kick")) {

				kicked.kickPlayer(utils.translate(Lang.Lang.getString("Kick-Layout").replaceAll("%reason%", reason).replaceAll("%kicked%", kicked.getName()).replaceAll("%kicker%", kicker.getName())));

				Bukkit.broadcastMessage(Lang.Lang.getString("Oversee.kickMessage")
						.replaceAll("%kicked%", kicked.getName()).replaceAll("%kicker%", kicker.getName()));

				return;

			}

		}

	}

	@EventHandler

	public void onChoose(AsyncPlayerChatEvent e) {

		Player p = (Player) e.getPlayer();
		String msg = e.getMessage();


		
		

		if (e.getMessage().equals("kick")) {

			choosingTarget.put(p.getUniqueId(), true);

			p.sendMessage(utils.translate(Oversee.prefix + "Please enter a valid username."));

			e.setCancelled(true);
			return;

		}

		if (choosingTarget.containsKey(p.getUniqueId())) {

			for (Player all : Bukkit.getOnlinePlayers()) {

				if (msg.equalsIgnoreCase(all.getName())) {
					
					Player target = Bukkit.getPlayer(msg);
					
					PlayerData.playersdata.set("Players.Tempo.Data." + p.getUniqueId(), target.getName());
					PlayerData.savePlayerData();
					

					
                    p.sendMessage("");
					p.sendMessage(utils.translate("&8&l&m-----------------------"));
					p.sendMessage("");
					p.sendMessage(utils.translate(Oversee.prefix + "&a&lSuccessfully &7entered a valid username!"));
					p.sendMessage("");
					p.sendMessage(utils.translate("&8&l&m-----------------------"));
					p.sendMessage("");
					
					p.sendMessage("");
					p.sendMessage(utils.translate(Oversee.prefix + "&7Please enter a reason."));
					p.sendMessage("");
					p.sendMessage("");
					choosingReason.put(p.getUniqueId(), true);

					
					e.setCancelled(true);
					return;

				}

				if (choosingReason.containsKey(p.getUniqueId())) {

	             choosingReason.remove(p.getUniqueId());
	             
	            
	                p.sendMessage("");
					p.sendMessage(utils.translate("&8&l&m-----------------------"));
					p.sendMessage("");
					p.sendMessage(utils.translate(Oversee.prefix + "&a&lSuccessfully &7entered a valid reason!\n"));
					p.sendMessage("");
					p.sendMessage("");
				p.sendMessage(utils.translate("&7You have kicked the player &b&l" + PlayerData.playersdata.getString("Players.Tempo.Data." + p.getUniqueId())  + "&b&l."));
					p.sendMessage("");
					p.sendMessage(utils.translate("&8&l&m-----------------------"));
					p.sendMessage("");
					
					
					Player player = Bukkit.getPlayer(PlayerData.playersdata.getString("Players.Tempo.Data." + p.getUniqueId()));
			
					Bukkit.getScheduler().runTask(plugin, new Runnable() {

						@Override
						public void run() {
						kickPlayer(p, player, msg);
							
						}
						
					});
					
					
					PlayerData.playersdata.set("Players.Temp.Data." + p.getUniqueId(), null);
					PlayerData.savePlayerData();


				}
			}
		}
	}

}
