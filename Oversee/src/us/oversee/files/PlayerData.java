package us.oversee.files;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerData {

	public static File playersdataFile;
	public static FileConfiguration playersdata;
	
	public static void init(File dataFolder) {
		
		playersdataFile = new File(dataFolder, "playerdata.yml");
		playersdata = YamlConfiguration.loadConfiguration(playersdataFile);
		
		if(!(playersdataFile.exists())) {
			savePlayerData();
			return;
		}
		
	}
	
	public static void savePlayerData() {
		
		try {
			
			playersdata.save(playersdataFile);
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
