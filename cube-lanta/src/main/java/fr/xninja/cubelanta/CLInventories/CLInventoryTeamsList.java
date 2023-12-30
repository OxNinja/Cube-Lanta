package fr.xninja.cubelanta.CLInventories;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import fr.xninja.cubelanta.CLGlobal;
import fr.xninja.cubelanta.CLTeam;

public class CLInventoryTeamsList extends CLInventory {
    public CLInventoryTeamsList() {
        size = 9 * ((CLGlobal.teams.size() / 9) + 1);
        name = "Teams list";
        inventory = Bukkit.createInventory(null, size, name);
        initializeItems();
    }

    @Override
    public void initializeItems() {
        size = 9 * (((CLGlobal.teams.size() - 1) / 9) + 1);
        update();
        ArrayList<ItemStack> items = new ArrayList<ItemStack>();
        if(CLGlobal.teams != null) {
            for(CLTeam team: CLGlobal.teams.values()) {
                String leaderName;
                if(team.leader == null) {
                    leaderName = "No leader";
                } else {
                    leaderName = team.getLeader().getName();
                }
                items.add(CLInventory.createGuiItem(team.material, team.name, "Leader: " + leaderName, "Members: " + String.valueOf(team.getMembers().size())));
            }
        }

        Integer i;
        for(i = 0; i < size; i++) {
            if(i < items.size()) {
                inventory.setItem(i, items.get(i));
            } else {
                inventory.setItem(i, new ItemStack(fill));
            }
        }
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

        if(!evt.getView().getTitle().equals(this.name)) {
            return;
        }

        evt.setCancelled(true);

        // open team management inventory -> members/leader, delete, customize...
        String target = item.getItemMeta().getDisplayName();
        CLInventory targetInventory = CLGlobal.inventories.get("team-manage-" + target);
        targetInventory.initializeItems();
        BukkitRunnable task = new CLInventoryTaskOpen(targetInventory.inventory, player);
        task.runTaskLater(CLGlobal.plugin, 1);
    }
}
