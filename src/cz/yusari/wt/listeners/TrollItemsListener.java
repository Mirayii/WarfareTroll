package cz.yusari.wt.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class TrollItemsListener implements Listener {
    public ArrayList<Location> diablock = new ArrayList<>();

    @EventHandler
    public void onTrollDiaPlace(BlockPlaceEvent e) {
        if (e.getItemInHand().hasItemMeta()) {
            if (e.getItemInHand().getItemMeta().hasDisplayName()) {
                if (e.getItemInHand().getItemMeta().hasLore()) {
                    if (e.getItemInHand().getItemMeta().getDisplayName().equals("§aTroll Diamond Block")) {
                        diablock.add(e.getBlock().getLocation());
                        e.getPlayer().sendMessage("§3WarfareTroll §8┃ §aBlok položen.");
                    }
                }
            }
        }
    }
    @EventHandler
    public void onTrollDiaBreak(BlockBreakEvent e) {
        if (diablock.contains(e.getBlock().getLocation())) {
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);
            e.getBlock().getLocation().getWorld().spawnEntity(e.getBlock().getLocation(), EntityType.CREEPER);
            e.getBlock().getLocation().getWorld().spawnEntity(e.getBlock().getLocation(), EntityType.CREEPER);
            e.getBlock().getLocation().getWorld().spawnEntity(e.getBlock().getLocation(), EntityType.CREEPER);
            e.getBlock().getLocation().getWorld().spawnEntity(e.getBlock().getLocation(), EntityType.CREEPER);
            e.getBlock().getLocation().getWorld().spawnEntity(e.getBlock().getLocation(), EntityType.CREEPER);

        }
    }
    @EventHandler
    public void TnTPlace(BlockPlaceEvent e) {
        if (e.getItemInHand().hasItemMeta()) {
            if (e.getItemInHand().getItemMeta().hasDisplayName()) {
                if (e.getItemInHand().getItemMeta().hasLore()) {
                    if (e.getItemInHand().getItemMeta().getDisplayName().equals("§aBreak lit TNT")) {
                        e.getPlayer().sendMessage("§3WarfareTroll §8┃ §aBlok položen.");
                        Block block = e.getBlock();
                        block.setData((byte)1);
                    }
                }
            }
        }
    }
    @EventHandler
    public void onPigFountainInteract(PlayerInteractEvent e) {
        if (e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {
            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName()) {
                if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                    if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§aPig Fountain")) {
                        Location l = e.getClickedBlock().getLocation();
                        l.getWorld().spawnEntity(l.add(0.0D, 2.0D, 0.0D), EntityType.PIG).setVelocity(new Vector(0.0D, 1.5D, 1.15D));
                        l.getWorld().spawnEntity(l.add(0.0D, 2.0D, 0.0D), EntityType.PIG).setVelocity(new Vector(1.15D, 1.5D, 1.15D));
                        l.getWorld().spawnEntity(l.add(0.0D, 2.0D, 0.0D), EntityType.PIG).setVelocity(new Vector(1.15D, 1.5D, 0.0D));

                        l.getWorld().spawnEntity(l.add(0.0D, 2.0D, 0.0D), EntityType.PIG).setVelocity(new Vector(0.0D, 1.5D, -1.15D));
                        l.getWorld().spawnEntity(l.add(0.0D, 2.0D, 0.0D), EntityType.PIG).setVelocity(new Vector(-1.15D, 1.5D, -1.15D));
                        l.getWorld().spawnEntity(l.add(0.0D, 2.0D, 0.0D), EntityType.PIG).setVelocity(new Vector(-1.15D, 1.5D, 0.0D));

                        l.getWorld().spawnEntity(l.add(0.0D, 2.0D, 0.0D), EntityType.PIG).setVelocity(new Vector(-1.15D, 1.5D, 1.15D));
                        l.getWorld().spawnEntity(l.add(0.0D, 2.0D, 0.0D), EntityType.PIG).setVelocity(new Vector(1.15D, 1.5D, -1.15D));
                        l.getWorld().playSound(l, Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
                    }
                }
            }
        }
    }
}
