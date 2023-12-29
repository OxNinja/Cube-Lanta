package fr.xninja.cubelanta.CLInventories;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import fr.xninja.cubelanta.CLTeam;

public class CLInventoryTeamManage extends CLInventory {

    CLTeam team;
    ItemStack teamLeaderItem;
    ArrayList<ItemStack> teamMembersItems;

    public CLInventoryTeamManage(CLTeam team) {
        this.team = team;
        size = 9 * 6;
        name = team.name;
        inventory = Bukkit.createInventory(null, size, name);
        initializeItems();
    }

    @Override
    public void initializeItems() {
        Integer i;
        for(i = 0; i < size; i++) {
            inventory.setItem(i, new ItemStack(fill));
        }

        if(team != null) {
            // Team leader
            if(team.getLeader() != null) {
                teamLeaderItem = CLInventory.getPlayerHead(team.getLeader());
                SkullMeta meta = (SkullMeta) teamLeaderItem.getItemMeta();
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("Team leader");
                meta.setLore(lore);
                teamLeaderItem.setItemMeta(meta);
            } else {
                teamLeaderItem = CLInventory.createGuiItem(Material.ZOMBIE_HEAD, "No leader", "");
            }
            inventory.setItem(0, teamLeaderItem);
            
            // Team members
            teamMembersItems = new ArrayList<ItemStack>();
            for(i = 0;i < team.members.size(); i++) {
                if(team.members.get(i).equals(team.getLeader())) {
                    continue;
                }

                ItemStack memberItem = CLInventory.getPlayerHead(team.members.get(i));
                teamMembersItems.add(memberItem);
                inventory.setItem(i + 1, memberItem);
            }

            // Team actions
            // TODO
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

        // TODO
    }
}
