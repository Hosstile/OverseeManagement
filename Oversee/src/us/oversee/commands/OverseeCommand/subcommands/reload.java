package us.oversee.commands.OverseeCommand.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.oversee.executors.SubCommand;
import us.oversee.files.Lang;
import us.oversee.interfaces.Messages;
import us.oversee.utillities.utils;

public class reload extends SubCommand {

	public reload(SubCommand parent) {
		super(parent);
	}

	@Override
	public void execute(CommandSender player, String[] args) {
		Player p = (Player) player;
		utils.reloadPlugin();
		
		p.sendMessage(utils.translate(Messages.prefix + "&cYou have reloaded the plugin!"));
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
		return "oversee.reload";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "reload";
	}

	@Override
	public boolean consoleUse() {
		// TODO Auto-generated method stub
		return false;
	}

}
