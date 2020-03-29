package us.oversee.commands.StaffChatCommand.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.avaje.ebean.enhance.agent.IgnoreClassHelper;

import us.oversee.events.StaffChatEvent;
import us.oversee.executors.SubCommand;
import us.oversee.files.Lang;
import us.oversee.utillities.utils;

public class unmute extends SubCommand{

	public unmute(SubCommand parent) {
		super(parent);
	}

	@Override
	public void execute(CommandSender player, String[] args) {
		Player p = (Player) player;
		StaffChatEvent.ignoreStaffChat.remove(p.getUniqueId());
		p.sendMessage(utils.translate(""+Lang.Lang.getString("NoLonger-IgnoreStaffChat")));
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
		return "unmute";
	}

	@Override
	public boolean consoleUse() {
		// TODO Auto-generated method stub
		return false;
	}

}
