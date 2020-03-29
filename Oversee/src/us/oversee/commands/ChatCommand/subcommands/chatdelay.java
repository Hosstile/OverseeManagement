package us.oversee.commands.ChatCommand.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.oversee.Management.ChatManagement.delaychat.DelayChat;
import us.oversee.executors.SubCommand;
import us.oversee.files.Settings;
import us.oversee.utillities.utils;

public class chatdelay extends SubCommand {

	public chatdelay(SubCommand parent) {
		super(parent);
	}

	@Override
	public void execute(CommandSender player, String[] args) {

		Player p = (Player) player;

		DelayChat.choosingDelay.put(p.getUniqueId(), true);
		Settings.settings.set("ChatDelay.Enabled", true);
		Settings.saveSettings();
		p.sendMessage(utils.translate(DelayChat.prefix + "Please enter a number from 1 - 10."));

		return;

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getUsage() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getPermission() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public boolean consoleUse() {
		// TODO Auto-generated method stub
		return false;
	}

}
