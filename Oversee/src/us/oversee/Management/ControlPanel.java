package us.oversee.Management;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import us.oversee.utillities.ItemBuilder;
import us.oversee.utillities.utils;

public class ControlPanel {
	

	
	public static String Controlprefix = utils.translate("&b&lControlPanel &8&l» &7");
	
	public static Inventory inv = Bukkit.createInventory(null, 45, utils.translate("&b&lControlPanel"));
	
	public static void openIventory(Player p) {
		p.openInventory(inv);
		p.sendMessage(utils.translate(Controlprefix + "Opening the ControlPanel!"));
		return;
	}
	
	public static void setItems(Integer place, ItemStack item) {
		inv.setItem(place - 1, item);
	}
	
	public static void init() {
		
		
		
		

		setItems(14, help);
		setItems(35-1, playerRelated);
		setItems(32, serverMonitoring);
		setItems(29 + 1, chatRelated);
		
		
		setItems(9, bars.clone());
		setItems(18, bars.clone());
		setItems(27, bars.clone());
		setItems(36, bars.clone());
		setItems(45, bars.clone());
		
		
		setItems(1, bars.clone());
		setItems(10, bars.clone());
		setItems(19, bars.clone());
		setItems(28, bars.clone());
		setItems(37, bars.clone());
		return;
		
	}
	
	
	

	static ItemStack help = new ItemBuilder(Material.PAPER).setName(utils.translate("&3&lHELP")).addLoreLine("").addLoreLine("&7&l&m----------------------").addLoreLine("").addLoreLine("&8(&7Left-click to view help&8)").addLoreLine("").addLoreLine("&7&l&m----------------------").addLoreLine("").toItemStack();
    static ItemStack chatRelated = new ItemBuilder(Material.BOOK).setName(utils.translate("&bChat Management")).addLoreLine("").addLoreLine("&7&l&m----------------------").addLoreLine("").addLoreLine("&f&lClick to view chat related management").addLoreLine("").addLoreLine("&7&l&m----------------------").addLoreLine("").toItemStack();
    static ItemStack playerRelated = new ItemBuilder(Material.BOOK).setName(utils.translate("&bPlayer Management")).addLoreLine("").addLoreLine("&7&l&m----------------------").addLoreLine("").addLoreLine("&f&lClick to view player related management").addLoreLine("").addLoreLine("&7&l&m----------------------").addLoreLine("").toItemStack();
    static ItemStack serverMonitoring = new ItemBuilder(Material.BOOK).setName(utils.translate("&bServer Monitoring")).addLoreLine("").addLoreLine("&7&l&m----------------------").addLoreLine("").addLoreLine("&f&lClick to view server related monitoring").addLoreLine("").addLoreLine("&7&l&m----------------------").addLoreLine("").toItemStack();
    static ItemStack bars = new ItemBuilder(Material.IRON_FENCE).toItemStack();
}
