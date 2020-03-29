package us.oversee.commands.OverseeCommand;

import us.oversee.commands.OverseeCommand.subcommands.reload;
import us.oversee.executors.Command;

public class Primary extends Command{

	public Primary(us.oversee.Oversee Oversee) {
		super(Oversee, "oversee");
		//this.registerSubCommand("panel", new panel(this));
		this.registerSubCommand("reload", new reload(this));
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
		return "oversee";
	}

	@Override
	public boolean consoleUse() {
		// TODO Auto-generated method stub
		return false;
	}

}
