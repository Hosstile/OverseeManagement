package us.oversee.commands.ChatCommand.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.oversee.Management.ChatManagement.clearchat.ClearChat;
import us.oversee.executors.SubCommand;

public class clearchat extends SubCommand {

	public clearchat(SubCommand parent) {
		super(parent);
	}

	@Override
	public void execute(CommandSender player, String[] args) {
		Player p = (Player) player;
		
		ClearChat.clearChat(p);
		
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
		return "clear";
	}

	@Override
	public boolean consoleUse() {
		// TODO Auto-generated method stub
		return false;
	}

}
