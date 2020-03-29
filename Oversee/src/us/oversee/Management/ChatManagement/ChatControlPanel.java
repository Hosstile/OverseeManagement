package us.oversee.Management.ChatManagement;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import us.oversee.utillities.ItemBuilder;
import us.oversee.utillities.utils;

public class ChatControlPanel {

	public static String prefix = utils.translate("&b&lChatManagement &8&l»  &7");
	public static Inventory inv = Bukkit.createInventory(null, 9, utils.translate("&b&lChatManagement"));

	public static void init() {

		inv.setItem(1, staff);
		inv.setItem(2, Clearchat);
		inv.setItem(3, ChatFilter);
		inv.setItem(4, lockchat);
		inv.setItem(0, delaychat);

	}

	public static void openInventory(Player p) {
		p.openInventory(inv);

		p.sendMessage(utils.translate(prefix + "Opening ChatManagement panel!"));
		return;

	}

	static ItemStack is = new ItemBuilder(Material.STAINED_GLASS_PANE).setDyeColor(DyeColor.BLUE).toItemStack();
	
	static ItemStack staff = new ItemBuilder(Material.PAPER).setName(utils.translate("&3&lStaffChat")).addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("")
			.addLoreLine("&8( &f&l>> &7Click to toggle StaffChat &f&l<< &8)").addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("").toItemStack();

	static ItemStack Clearchat = new ItemBuilder(Material.PAPER).setName(utils.translate("&3&lClearChat"))
			.addLoreLine("").addLoreLine("&7&l&m----------------------").addLoreLine("")
			.addLoreLine("&8( &f&l>> &7Click to ClearChat &f&l<< &8)").addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("").toItemStack();

	static ItemStack ChatFilter = new ItemBuilder(Material.PAPER)
			.setName(utils.translate("&3&lChatFilter")).addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("")
			.addLoreLine("&8( &f&l>> &7Click to toggle ChatFilter &f&l<< &8)").addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("").toItemStack();

	static ItemStack lockchat = new ItemBuilder(Material.PAPER).setName(utils.translate("&3&lLockChat")).addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("")
			.addLoreLine("&8( &f&l>> &7Click to Lock/Unlock Chat &f&l<< &8)").addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("").toItemStack();

	static ItemStack delaychat = new ItemBuilder(Material.PAPER).setName(utils.translate("&3&lDelayChat")).addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("")
			.addLoreLine("&8( &f&l>> &7Click to Delay Chat &f&l<< &8)").addLoreLine("")
			.addLoreLine("&7&l&m----------------------").addLoreLine("").toItemStack();

}
