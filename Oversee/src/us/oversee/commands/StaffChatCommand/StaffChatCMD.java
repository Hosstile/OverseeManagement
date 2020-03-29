package us.oversee.commands.StaffChatCommand;

import us.oversee.commands.StaffChatCommand.subcommands.mute;
import us.oversee.commands.StaffChatCommand.subcommands.toggle;
import us.oversee.commands.StaffChatCommand.subcommands.unmute;
import us.oversee.executors.Command;

public class StaffChatCMD extends Command{

	public StaffChatCMD(us.oversee.Oversee Oversee) {
		super(Oversee, "staffchat");
		this.registerSubCommand("toggle", new toggle(this));
		this.registerSubCommand("mute", new mute(this));
		this.registerSubCommand("unmute", new unmute(this));
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
		return "oversee.staffchat";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "staffchat";
	}

	@Override
	public boolean consoleUse() {
		// TODO Auto-generated method stub
		return false;
	}

}
