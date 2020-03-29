package us.oversee.commands.StaffChatCommand.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.oversee.Management.ChatManagement.staffchat.StaffChat;
import us.oversee.executors.SubCommand;

public class toggle extends SubCommand {

	public toggle(SubCommand parent) {
		super(parent);
	}

	@Override
	public void execute(CommandSender player, String[] args) {
		Player p = (Player) player;

		StaffChat.togglePlayer(p);
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
		return "toggle";
	}

	@Override
	public boolean consoleUse() {
		// TODO Auto-generated method stub
		return false;
	}

}
