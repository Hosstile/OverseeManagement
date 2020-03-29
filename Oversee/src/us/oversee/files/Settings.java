package us.oversee.files;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Settings {

	public static File settingsFile;
	public static FileConfiguration settings;
	
	public static void init(File dataFolder) {
		
		settingsFile = new File(dataFolder, "settings.yml");
		settings = YamlConfiguration.loadConfiguration(settingsFile);
		
		if(!(settingsFile.exists())) {
			
			Settings.settings.set("StaffChat-Enabled", true);
			Settings.settings.set("ChatDelay", false);
			Settings.settings.set("Blacklist.Enabled", false);
			Settings.settings.set("Chat-Filter", true);
			Settings.settings.set("Kick.Notify", true);
			Settings.settings.set("Announce-Bans", false);
			Settings.settings.set("NotifyJoinBanned", true);
			
			
			saveSettings();
			return;
		}
		
	}
	
	public static void saveSettings() {
		
		try {
			
			settings.save(settingsFile);
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
