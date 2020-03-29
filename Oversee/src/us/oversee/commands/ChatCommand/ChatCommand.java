package us.oversee.commands.ChatCommand;

import us.oversee.commands.ChatCommand.subcommands.blacklist;
import us.oversee.commands.ChatCommand.subcommands.chatdelay;
import us.oversee.commands.ChatCommand.subcommands.clearchat;
import us.oversee.executors.Command;

public class ChatCommand extends Command{

	public ChatCommand(us.oversee.Oversee Oversee) {
		super(Oversee, "chat");
		this.registerSubCommand("delay", new chatdelay(this));
		this.registerSubCommand("clear", new clearchat(this));
		this.registerSubCommand("blacklist", new blacklist(this));
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
		return "chat";
	}

	@Override
	public boolean consoleUse() {
		// TODO Auto-generated method stub
		return false;
	}

}
