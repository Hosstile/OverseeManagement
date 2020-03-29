package us.oversee.commands.OverseeCommand.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.oversee.Management.ControlPanel;
import us.oversee.executors.SubCommand;

public class panel extends SubCommand{

	public panel(SubCommand parent) {
		super(parent);
	}

	@Override
	public void execute(CommandSender player, String[] args) {
		Player p = (Player) player;
		ControlPanel.openIventory(p);
		
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
		return "oversee.panel";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "panel";
	}

	@Override
	public boolean consoleUse() {
		// TODO Auto-generated method stub
		return false;
	}

}
