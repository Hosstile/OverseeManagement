package us.oversee.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import us.oversee.Management.ChatManagement.ChatControlPanel;
import us.oversee.Management.ChatManagement.clearchat.ClearChat;
import us.oversee.Management.PlayerManagement.PlayerControlPanel;
import us.oversee.utillities.utils;

public class ClickGUI implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		ItemStack clicked = e.getCurrentItem();

		if (e.getInventory().getTitle().equalsIgnoreCase(utils.translate("&b&lControlPanel"))) {

			if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(utils.translate("&bChat Management"))) {

				e.setCancelled(true);

				ChatControlPanel.openInventory(p);

				return;

			}

			if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(utils.translate("&bPlayer Management"))) {

				e.setCancelled(true);

				PlayerControlPanel.openInventory(p);

				return;

			}

			if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(utils.translate("&bServer Monitor"))) {

				e.setCancelled(true);

				return;

			}

			if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(utils.translate("&3&lHELP"))) {

				e.setCancelled(true);

				return;

			}

			if (!clicked.getItemMeta().getDisplayName().equalsIgnoreCase(utils.translate("&3&lHELP"))) {
				if (!clicked.getItemMeta().getDisplayName().equalsIgnoreCase(utils.translate("&bServer Monitor"))) {
					if (!clicked.getItemMeta().getDisplayName()
							.equalsIgnoreCase(utils.translate("&bPlayer Management"))) {
						if (!clicked.getItemMeta().getDisplayName()
								.equalsIgnoreCase(utils.translate("&bChat Management"))) {

							e.setCancelled(true);
							return;

						}

					}

				}
			}
		}

		if (e.getInventory().getTitle().equalsIgnoreCase(utils.translate("&b&lChatManagement"))) {

			if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(utils.translate("&3&lClearChat"))) {

				ClearChat.clearChat(p);
				e.setCancelled(true);
				p.closeInventory();
				return;

			}

		}
	}

}
