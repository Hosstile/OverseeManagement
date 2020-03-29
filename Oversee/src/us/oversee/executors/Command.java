package us.oversee.executors;

import java.util.HashMap;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.oversee.Oversee;
import us.oversee.interfaces.Messages;
import us.oversee.utillities.utils;


public abstract class Command extends SubCommand implements CommandExecutor {

	private HashMap<String, SubCommand> subCommands = new HashMap<>();

	private String name;

	private Oversee Oversee;

	public Command(Oversee Oversee, String name2) {
		super(null);
		this.name = name;
		this.Oversee = Oversee;
	}

	public Command registerSubCommand(String name, SubCommand subCommand) {
		this.subCommands.put(name, subCommand);
		return this;
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command Overseed, String label, String[] args) {
		if (!(sender instanceof Player)) {
			if (!this.anyConsoleUse()) {

				return true;
			}
			if (args.length == 0) {
				execute(sender, args);
				return true;
			}
			if (!subCommands.containsKey(args[0].toLowerCase())) {
				sender.sendMessage(utils.translate(Messages.prefix + "&cInvalid usage, Please use /Oversee help."));
				return true;
			}
			SubCommand sub = this.subCommands.get(args[0].toLowerCase());
			if (!sub.consoleUse()) {
				return true;
			}
			sub.execute(sender, args);
			return true;
		}
		Player player = (Player) sender;
		if (args.length == 0) {
			if (!player.hasPermission(getPermission())) {
				sender.sendMessage(utils.translate(Messages.prefix + "&cYou don't have access to this command!."));
				return true;
			}
			execute(player, args);
			return true;
		}
		if (!subCommands.containsKey(args[0].toLowerCase())) {
			sender.sendMessage(utils.translate(Messages.prefix + "&cInvalid usage, Please use /Oversee help."));
			return true;
		}
		SubCommand sub = this.subCommands.get(args[0].toLowerCase());
		if (!player.hasPermission(sub.getPermission())) {
			sender.sendMessage(utils.translate(Messages.prefix + "&cYou don't have access to this command!."));
			return true;
		}
		sub.execute(player, args);
		return true;
	}

	public boolean anyConsoleUse() {
		if (subCommands.isEmpty())
			return false;
		if (subCommands.values().stream().anyMatch(SubCommand::consoleUse))
			return true;
		return false;
	}

	public void execute(CommandSender player, String[] args) {
		Player p = (Player) player;
		
		player.sendMessage(" ");
		
		p.sendMessage(utils.translate("&8&l&m----------------------------"));
		p.sendMessage(utils.translate(""));
		p.sendMessage(utils.translate("                     &5&lOVERSEE"));
		p.sendMessage("");
		p.sendMessage(utils.translate(" "));
		p.sendMessage(utils.translate("&c/oversee panel"));
		p.sendMessage(utils.translate("&c/oversee reload"));
		p.sendMessage(utils.translate(" "));
		p.sendMessage("");
		p.sendMessage(utils.translate("&b&l/chat &3help"));
		p.sendMessage(utils.translate("&b&l/chat &3delay"));
		p.sendMessage(utils.translate("&b&l/chat &3clear"));
		p.sendMessage(utils.translate("&b&l/chat &3toggle"));
		p.sendMessage(utils.translate("&b&l/chat &3whitelist &7<player>"));
		p.sendMessage(utils.translate("&b&l/chat &3blacklist &7<player>"));
		p.sendMessage(" ");
		p.sendMessage(utils.translate("&a&l/staffchat &2mute"));
		p.sendMessage(utils.translate("&a&l/staffchat &2unmute"));
		p.sendMessage(utils.translate("&a&l/staffchat &2toggle"));
		p.sendMessage(" ");
		p.sendMessage(utils.translate("&6&l/manage &ekick"));
		p.sendMessage(utils.translate(" "));
		p.sendMessage(utils.translate("&8&l&m----------------------------"));
		
		
		//subCommands.values().forEach(sub -> {
			//player.sendMessage(ChatColor.translateAlternateColorCodes('&', "\n&7/" + name + " " + sub.getName()
					//+ (sub.getUsage().length() == 0 ? "" : " &7" + sub.getUsage())));
			
						
		//});
	}

	public Oversee getOversee() {
		return Oversee;
	}

}