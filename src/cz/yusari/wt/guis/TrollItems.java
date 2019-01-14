package cz.yusari.wt.guis;

import cz.yusari.wt.utils.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TrollItems implements Listener {

        public static void openMenu(final Player p) {
            if (!p.hasPermission("wt.admin") || !p.isOp()) {
                p.sendMessage("§cNa tohle nemáš povolení");
            }

            Inventory inv = Bukkit.createInventory(null, 27, "§3WarfareTroll - Items");
            for (int i = 0;i<27;i++) {
                ItemStack fill = ItemFactory.create(Material.STAINED_GLASS_PANE, (byte) 15, "§8");
                inv.setItem(i, fill);
            }
            ItemStack pigfountain = ItemFactory.create(Material.MONSTER_EGG, (byte) 0, "§aPig Fountain", "§8• §7Rozhodí prasata v okolí jako fontána");
            inv.setItem(10, pigfountain);
        }
        @EventHandler
        private void onDrop(PlayerDropItemEvent e) {
            final Player p =  e.getPlayer();
            if (p.getInventory().getTitle().equals("§3WarfareTroll - Items")) {
                e.setCancelled(true);
            }
        }

        @EventHandler
        private void onInteract(InventoryClickEvent e) {
            final Player p = (Player) e.getWhoClicked();
            if (e.getInventory().getTitle().equals("§3WarfareTroll - Items")) {
                e.setCancelled(true);
                if (e.getCurrentItem() == null) {
                    return;
                }
                if (e.getCurrentItem().getType() == Material.AIR) {
                    return;
                }
                if (e.getSlot() == 10) {
                    ItemStack item = ItemFactory.create(Material.MONSTER_EGG, (byte) 0, "§aPig Fountain", "§7WarfareTroll");
                    p.getInventory().addItem(item);
                    p.sendMessage("§3WarfareTroll §8┃ §aUžij si " + item.getItemMeta().getDisplayName());
                    p.sendMessage("§3WarfareTroll §8┃ §aNávod: §fKlikni s itemem na zem");
                }
            }
        }

}
