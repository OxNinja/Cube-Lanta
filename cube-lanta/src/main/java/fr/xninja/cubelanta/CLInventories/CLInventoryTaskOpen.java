package fr.xninja.cubelanta.CLInventories;

import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

public class CLInventoryTaskOpen extends BukkitRunnable {

    Inventory inventory;
    HumanEntity player;

    CLInventoryTaskOpen(Inventory inventory, HumanEntity player) {
        this.inventory = inventory;
        this.player = player;
    }

    @Override
    public void run() {
        if(player == null || inventory == null) {
            System.out.println("Inventory task open: player or inventory is null");
            return;
        }
        player.openInventory(inventory);
    }
}
