package us.oversee.commands.ManageCommand.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.oversee.Oversee;
import us.oversee.Management.PlayerManagement.kick.Kick;
import us.oversee.executors.SubCommand;
import us.oversee.utillities.utils;

public class kick extends SubCommand {

	public kick(SubCommand parent) {
		super(parent);

	}

	@Override
	public void execute(CommandSender player, String[] args) {
		Player p = (Player) player;

		Kick.choosingTarget.put(p.getUniqueId(), true);

		p.sendMessage(utils.translate(Oversee.prefix + "Please enter a valid username."));

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
		return "suspend";
	}

	@Override
	public boolean consoleUse() {
		// TODO Auto-generated method stub
		return false;
	}

}
