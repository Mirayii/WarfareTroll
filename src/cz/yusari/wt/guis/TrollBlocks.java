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

public class TrollBlocks implements Listener {

    public static void openMenu(final Player p) {
        if (!p.hasPermission("wt.admin") || !p.isOp()) {
            p.sendMessage("§cNa tohle nemáš povolení");
        }

        Inventory inv = Bukkit.createInventory(null, 27, "§3WarfareTroll - Blocks");
        for (int i = 0;i<27;i++) {
            ItemStack fill = ItemFactory.create(Material.STAINED_GLASS_PANE, (byte) 15, "§8");
            inv.setItem(i, fill);
        }
        ItemStack diablock = ItemFactory.create(Material.DIAMOND_BLOCK, (byte) 0, "§aTroll Diamond Block", "§8• §7Po položení se blok bude chovat", "§7jako normální Dia blok, ale", "§7po zníčení se spawne Creeper");
        inv.setItem(10, diablock);
        ItemStack tnt = ItemFactory.create(Material.TNT, (byte) 0, "§aBreak lit TNT", "§8• §7Po zníčení tohoto TNT bude", "§7automaticky TNT zapáleno");
        inv.setItem(11, tnt);
    }
    @EventHandler
    private void onDrop(PlayerDropItemEvent e) {
        final Player p =  e.getPlayer();
        if (p.getInventory().getTitle().equals("§3WarfareTroll - Blocks")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    private void onInteract(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equals("§3WarfareTroll - Blocks")) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (e.getSlot() == 10) {
                ItemStack item = ItemFactory.create(Material.DIAMOND_BLOCK, (byte) 0, "§aTroll Diamond Block", "§7WarfareTroll");
                p.getInventory().addItem(item);
                p.sendMessage("§3WarfareTroll §8┃ §aUžij si " + item.getItemMeta().getDisplayName());
                p.sendMessage("§3WarfareTroll §8┃ §aNávod: §fPolož blok a nech ho hráče vykopat. Po zníčení blok nepadne a Spawne se Creeper.");
            }
            if (e.getSlot() == 11) {
                ItemStack item = ItemFactory.create(Material.TNT, (byte) 0, "§aBreak lit TNT", "§7WarfareTroll");
                p.getInventory().addItem(item);
                p.sendMessage("§3WarfareTroll §8┃ §aUžij si " + item.getItemMeta().getDisplayName());
                p.sendMessage("§3WarfareTroll §8┃ §aNávod: §fPolož blok a nech ho hráče vykopat. Po zníčení se spawne zapálené TNT, avšak nic nezníčí a hráčovi ubere HP.");
            }
        }
    }
}
