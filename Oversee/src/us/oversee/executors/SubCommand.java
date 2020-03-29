package us.oversee.executors;

import org.bukkit.command.CommandSender;

import us.oversee.Oversee;

public abstract class SubCommand {

	private SubCommand parent;

	public SubCommand(SubCommand parent) {
		this.parent = parent;
	}

	public SubCommand getParent() {
		return this.parent;
	}

	public Oversee getOversee() {
		if (this instanceof Command) {
			return ((Command) this).getOversee();
		}
		return null;
	}

	public abstract void execute(CommandSender player, String args[]);

	public abstract String getDescription();

	public abstract String getUsage();

	public abstract String getPermission();

	public abstract String getName();

	public abstract boolean consoleUse();

}