package us.oversee.files;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Lang {

	public static File LangFile;
	public static FileConfiguration Lang;

	public static void init(File dataFolder) {

		LangFile = new File(dataFolder, "lang.yml");
		Lang = YamlConfiguration.loadConfiguration(LangFile);

		if (!(LangFile.exists())) {

			Lang.set("StaffChat-Format", "&a&lSC&8&l >> &7%sender% &8&l: &f%message%&7.");
			Lang.set("ChatDelay-Cooldown",
					"&b&lOversee Delay &8&l: &7Please wait &b%delay% &7before typing, as chat has a delay currently. ");
			Lang.set("Chat-Cleared", "&b&lOversee &8&l: &cChat has been cleared by %player%!");
			Lang.set("BypassClearChat", "&b&lOversee &8&l: &cYou have bypassed ClearChat");
			Lang.set("FilterBlocked", "&b&lOversee ChatFilter &8&l» &4&lHEY! &cthat word is forbidden on this server!");
			Lang.set("Kick-NoPlayer", "&b&lOversee &8&l: &4%args% &cCouldn't be found!");
			Lang.set("Kick-Layout", "   &b&lOversee\n      &7We regret to inform you that you've been kicked for the following reason&8:\n \n&b&lKicker&8: &f&l%kicker% \n \n&b&lReason&8: &f&l%reason%");
            Lang.set("Bans-Announce", "&b&lOversee Bans &8&l: &b%player% &7was just &bsuspended&7 for &b%reason%&7, by &b%banner%");
            Lang.set("NotifyJoinBan", "&b&lOversee Bans &8>> &f&l%player% &7 has attempted to join, but is &b&lSUSPENDED&7.\n \n &b&lUUID &8>> &7%uuid% \n &b&lIP &8&l: &7%ip%");
			Lang.set("IgnoreStaffChat", "&a&lSC&8&l >> &7You are &cnow &7ignoring staff-chat messages");
		Lang.set("NoLonger-IgnoreStaffChat", "&a&lSC&8&l >> &7You are &cno&7-longer ignoring staff-chat messages");
			saveLang();
			return;
		}

	}

	public static void saveLang() {

		try {

			Lang.save(LangFile);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
