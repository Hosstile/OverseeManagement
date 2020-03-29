package us.oversee.Management.ChatManagement.staffchat;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.command.defaults.PlaySoundCommand;
import org.bukkit.entity.Player;

import us.oversee.files.Settings;
import us.oversee.utillities.utils;

public class StaffChat {
	public static String prefix = utils.translate("&b&lSTAFFCHAT&8&l: &7");

	public static HashMap<UUID, Player> staffchat = new HashMap<UUID, Player>();
	public static HashMap<UUID, Boolean> playerState = new HashMap<UUID, Boolean>();

	public static void togglePlayer(Player p) {

		if (p.hasPermission("oversee.staffchat")  || p.isOp() && Settings.settings.getBoolean("StaffChat-Enabled") == true) {

			if (playerState.get(p.getUniqueId()) == null) {

				playerState.put(p.getUniqueId(), true);
				p.sendMessage(utils.translate(prefix + "You toggled &f&lON&7 Staffchat."));

				return;

			} else if (playerState.get(p.getUniqueId()) == true) {
				playerState.put(p.getUniqueId(), null);

				p.sendMessage(utils.translate(prefix + "You toggled &f&lOFF&7 Staffchat."));

				return;

			} else if (!(p.hasPermission("oversee.staffchat"))) {

				p.sendMessage(utils.translate(prefix + "&cYou don't have the correct permission!"));
				return;
			}

		}
	}

}
