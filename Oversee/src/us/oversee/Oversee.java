package us.oversee;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import us.oversee.Management.ControlPanel;
import us.oversee.Management.ChatManagement.ChatControlPanel;
import us.oversee.Management.ChatManagement.chatfilter.FilteredWords;
import us.oversee.Management.ChatManagement.delaychat.DelayChat;
import us.oversee.Management.PlayerManagement.PlayerControlPanel;
import us.oversee.Management.PlayerManagement.kick.Kick;
import us.oversee.commands.ChatCommand.ChatCommand;
import us.oversee.commands.ManageCommand.ManageCMD;
import us.oversee.commands.OverseeCommand.Primary;
import us.oversee.commands.StaffChatCommand.StaffChatCMD;
import us.oversee.events.ClickGUI;
import us.oversee.events.FilterBlock;
import us.oversee.events.StaffChatEvent;
import us.oversee.files.Lang;
import us.oversee.files.PlayerData;
import us.oversee.files.Settings;
import us.oversee.utillities.utils;

public class Oversee extends JavaPlugin implements Listener {

	public static String prefix = utils.translate("&b&lOversee &8&l» &7");

	public void onEnable() {

		handler();

	}

	public void onDisable() {

	}

	private void handler() {
		registerCFG();
		registerCommands();
		registerEvents();
		ControlPanel.init();
		ChatControlPanel.init();
		PlayerControlPanel.init();

	}

	private void registerEvents() {

		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(this, this);
		pm.registerEvents(new FilteredWords(this), this);
		pm.registerEvents(new DelayChat(this), this);
		pm.registerEvents(new Kick(this), this);
		pm.registerEvents(new ClickGUI(), this);
		pm.registerEvents(new StaffChatEvent(), this);

	}

	private void registerCFG() {

		getConfig().options().copyDefaults(true);
		Bukkit.getConsoleSender().sendMessage(utils.translate("&b&lOversee &8&l: &7Loaded config.yml"));
		saveConfig();
		Settings.init(getDataFolder());
		PlayerData.init(getDataFolder());
		Lang.init(getDataFolder());

	}

	private void registerCommands() {
		
		getCommand("oversee").setExecutor(new Primary(this));
		getCommand("chat").setExecutor(new ChatCommand(this));
		getCommand("staffchat").setExecutor(new StaffChatCMD(this));
		getCommand("manage").setExecutor(new ManageCMD(this));

	}

	
}
