package us.oversee.utillities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import us.oversee.files.Lang;
import us.oversee.files.PlayerData;
import us.oversee.files.Settings;
import us.oversee.interfaces.Messages;

public class utils {

	public static String translate(String args) {

		return ChatColor.translateAlternateColorCodes('&', args);

	}

	public static void sendMSG(Player p, String msg) {

		p.sendMessage(utils.translate(msg));

	}

	public static void cms(String msg) {
		Bukkit.getConsoleSender().sendMessage(utils.translate(msg));
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void reloadPlugin() {

		Lang.Lang = YamlConfiguration.loadConfiguration(Lang.LangFile);
		Settings.settings = YamlConfiguration.loadConfiguration(Settings.settingsFile);
		PlayerData.playersdata = YamlConfiguration.loadConfiguration(PlayerData.playersdataFile);

		cms(Messages.prefix + "&cReloaded &flang.yml&c.");
		cms(Messages.prefix + "&cReloaded &fsettings.yml&c.");
		cms(Messages.prefix + "&cReloaded &fplayerdata.yml&c.");

	}

}
