package fr.xninja.cubelanta.CLInventories;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CLInventory implements Listener {
    public Inventory inventory;
    public Integer size = 27;
    public Material fill = Material.AIR;
    public String name = "CubeLanta inventory";

    public CLInventory() {
        inventory = Bukkit.createInventory(null, size, name);
        initializeItems();
    }

    public void initializeItems() {
        Integer i;
        for(i = 0; i < size; i++) {
            inventory.setItem(i, new ItemStack(fill));
        }
    }

    public void openInventory(Player player) {
        player.openInventory(inventory);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent evt) {
        HumanEntity player = evt.getWhoClicked();
        ItemStack item = evt.getCurrentItem();
        Inventory inventory = evt.getClickedInventory();
        
        if(inventory == null || inventory.getType() == InventoryType.PLAYER || item == null || !(player instanceof Player)) {
            return;
        }
                        
        player.closeInventory();
        Integer slot = evt.getRawSlot();
        evt.setCancelled(true);

        player.sendMessage("Clicked on slot " + slot);
    }

    @EventHandler
    public void onInventoryClick(InventoryDragEvent evt) {
        if (evt.getInventory().equals(inventory)) {
          evt.setCancelled(true);
        }
    }

    public static ItemStack createGuiItem(Material material, String name, String... lore) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        return item;
    }
}
