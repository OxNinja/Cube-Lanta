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

public class CLInventoryAdminTeams extends CLInventory {

    ItemStack itemTeamCreate = CLInventory.createGuiItem(Material.SMITHING_TABLE, "Create team", "Create a new team");
    ItemStack itemTeamList = CLInventory.createGuiItem(Material.WHITE_BANNER, "List teams", "List all the teams");
    ItemStack itemTeamRemove = CLInventory.createGuiItem(Material.LAVA_BUCKET, "Remove team", "Remove a team");
    
    public CLInventoryAdminTeams() {
        this.name = "Admin team management";
        this.size = 18;
        inventory = Bukkit.createInventory(null, size, name);
        initializeItems();
    }

    @Override
    public void initializeItems() {
        Integer i;
        for(i = 0; i < size; i++) {
            inventory.setItem(i, new ItemStack(fill));
        }
        inventory.setItem(0, itemTeamCreate);
        inventory.setItem(1, itemTeamList);
        inventory.setItem(2, itemTeamRemove);
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
        
        // Action dispatch
        if(item.isSimilar(itemTeamCreate)) {
            player.sendMessage("To create a team, run the command: /cl-team-create my-team");
        } else if(item.isSimilar(itemTeamList)) {
            // Update all teams in the inventory before opening it
            CLGlobal.inventories.get("teams-list").initializeItems();
            BukkitRunnable task = new CLInventoryTaskOpen(CLGlobal.inventories.get("teams-list").inventory, player);
            task.runTaskLater(CLGlobal.plugin, 1);
        } else if(item.isSimilar(itemTeamRemove)) {
            
        }
    }
}
