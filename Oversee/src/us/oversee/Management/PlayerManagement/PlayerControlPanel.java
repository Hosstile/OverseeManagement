package us.oversee.Management.PlayerManagement;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import us.oversee.utillities.ItemBuilder;
import us.oversee.utillities.utils;

public class PlayerControlPanel {

	public static String prefix = utils.translate("&b&lPlayerManagement &8&l»  &7");
	public static Inventory inv = Bukkit.createInventory(null, 9, utils.translate("&b&lPlayer Management"));

	public static void init() {

		inv.setItem(0, kick);
		inv.setItem(1, ban);
		inv.setItem(2, denyjoin);
		inv.setItem(3, Freeze);;

	}

	public static void openInventory(Player p) {
		p.openInventory(inv);

		p.sendMessage(utils.translate(prefix + "Opening PlayerManagement panel!"));
		return;

	}

	static ItemStack is = new ItemBuilder(Material.STAINED_GLASS_PANE).setDyeColor(DyeColor.BLUE).toItemStack();
	
	static ItemStack kick = new ItemBuilder(Material.PAPER).setName(utils.translate("&3&lKick")).addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("")
			.addLoreLine("&8( &f&l>> &7Kick a player &f&l<< &8)").addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("").toItemStack();

	static ItemStack ban = new ItemBuilder(Material.PAPER).setName(utils.translate("&3&lPermanently Ban"))
			.addLoreLine("").addLoreLine("&7&l&m----------------------").addLoreLine("")
			.addLoreLine("&8( &f&l>> &7Permanently ban a player &f&l<< &8)").addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("").toItemStack();

	static ItemStack denyjoin = new ItemBuilder(Material.PAPER).setName(utils.translate("&3&lDenyJoin")).addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("")
			.addLoreLine("&8( &f&l>> &7Temporarily disable a players join ability &f&l<< &8)").addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("").toItemStack();

	static ItemStack Freeze = new ItemBuilder(Material.PAPER).setName(utils.translate("&3&lFreeze")).addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("")
			.addLoreLine("&8( &f&l>> &7Freeze a player &f&l<< &8)").addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("").toItemStack();

}
