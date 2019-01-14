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

public class MainMenuGUI implements Listener {

    public static void openMenu(final Player p) {
        if (!p.hasPermission("wt.admin") || !p.isOp()) {
            p.sendMessage("§cNa tohle nemáš povolení");
        }
        if (p.getName().equalsIgnoreCase("Mesiac")) {
            p.sendMessage("Moon je L\n§7S láskou Yusari (Toto se zobrazuje jen tobě) [][][][][] xdddddddddd");
        }
        Inventory inv = Bukkit.createInventory(null, 27, "§3WarfareTroll");
        for (int i = 0;i<27;i++) {
            ItemStack fill = ItemFactory.create(Material.STAINED_GLASS_PANE, (byte) 15, "§8");
            inv.setItem(i, fill);
        }
        ItemStack blocks = ItemFactory.create(Material.DIAMOND_BLOCK, (byte) 0, "§aTroll Blocks", "§7Kliknutím otevřeš!");
        inv.setItem(10, blocks);
        ItemStack items = ItemFactory.create(Material.MOB_SPAWNER, (byte) 0, "§aTroll Items", "§7Kliknutím otevřeš!");
        inv.setItem(11, items);
        p.openInventory(inv);
    }
    @EventHandler
    private void onDrop(PlayerDropItemEvent e) {
        final Player p =  e.getPlayer();
        if (p.getInventory().getTitle().equals("§3WarfareTroll")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    private void onInteract(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("§3WarfareTroll")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 10) {
                TrollBlocks.openMenu(p);
                p.sendMessage("§3WarfareTroll §8┃ §aOtevřeno menu Blocks");
            }
            if (e.getSlot() == 11) {
                TrollItems.openMenu(p);
                p.sendMessage("§3WarfareTroll §8┃ §aOtevřeno menu Items");
            }
        }
    }
}
