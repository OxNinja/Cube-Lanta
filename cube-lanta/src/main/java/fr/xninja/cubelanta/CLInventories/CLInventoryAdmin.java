package fr.xninja.cubelanta.CLInventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import fr.xninja.cubelanta.CLGlobal;

public class CLInventoryAdmin extends CLInventory {

    ItemStack teamManagementItem = CLInventory.createGuiItem(Material.NETHER_STAR, "Team management", "See team-related actions");

    public CLInventoryAdmin() {
        this.size = 9;
        this.name = "Admin management";
        inventory = Bukkit.createInventory(null, size, name);
        initializeItems();
    }

    @Override
    public void initializeItems() {
        Integer i;
        for(i = 0; i < size; i++) {
            inventory.setItem(i, new ItemStack(fill));
        }
        inventory.setItem(0, teamManagementItem);
    }

    @Override
    @EventHandler
    public void onInventoryClick(InventoryClickEvent evt) {
        HumanEntity player = evt.getWhoClicked();
        ItemStack item = evt.getCurrentItem();
        Inventory inventory = evt.getClickedInventory();
        
        if(inventory == null || inventory.getType() == InventoryType.PLAYER || item == null || !(player instanceof Player)) {
            return;
        }
                     
        evt.setCancelled(true);

        // Action dispatch for item click
        if(item.isSimilar(teamManagementItem)) {
            BukkitRunnable task = new CLInventoryTaskOpen(CLGlobal.inventories.get("admin-teams").inventory, player);
            task.runTaskLater(CLGlobal.plugin, 1);
        }
    }

}
