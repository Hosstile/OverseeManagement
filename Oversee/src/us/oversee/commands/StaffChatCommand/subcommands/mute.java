package us.oversee.commands.StaffChatCommand.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.avaje.ebean.enhance.agent.IgnoreClassHelper;

import us.oversee.events.StaffChatEvent;
import us.oversee.executors.SubCommand;
import us.oversee.files.Lang;
import us.oversee.utillities.utils;

public class mute extends SubCommand{

	public mute(SubCommand parent) {
		super(parent);
	}

	@Override
	public void execute(CommandSender player, String[] args) {
		Player p = (Player) player;
		StaffChatEvent.ignoreStaffChat.put(p.getUniqueId(), p.getPlayer());
		p.sendMessage(utils.translate(""+Lang.Lang.getString("IgnoreStaffChat")));
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
		return "mute";
	}

	@Override
	public boolean consoleUse() {
		// TODO Auto-generated method stub
		return false;
	}

}
