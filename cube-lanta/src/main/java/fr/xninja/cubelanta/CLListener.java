package fr.xninja.cubelanta;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import fr.xninja.cubelanta.CLInventories.CLInventoryTaskOpen;

public class CLListener implements Listener {
    @EventHandler
    public void onPlayerUse(PlayerInteractEvent evt) {
        Player player = evt.getPlayer();
        ItemStack item = evt.getItem();

        if(item == null || !(player instanceof Player)) {
            return;
        }

        evt.setCancelled(true);

        if(item.isSimilar(CLGlobal.adminItem)) {
            BukkitRunnable task = new CLInventoryTaskOpen(CLGlobal.inventories.get("admin").inventory, player);
            task.runTaskLater(CLGlobal.plugin, 1);
        }
    }
}
