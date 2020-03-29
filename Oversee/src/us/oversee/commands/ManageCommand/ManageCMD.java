package us.oversee.commands.ManageCommand;

import us.oversee.commands.ManageCommand.subcommands.kick;

import us.oversee.executors.Command;

public class ManageCMD extends Command{

	public ManageCMD(us.oversee.Oversee Oversee) {
		super(Oversee, "manage");
		this.registerSubCommand("kick", new kick(this));

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
		return "oversee.manage";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "manage";
	}

	@Override
	public boolean consoleUse() {
		// TODO Auto-generated method stub
		return false;
	}

}
