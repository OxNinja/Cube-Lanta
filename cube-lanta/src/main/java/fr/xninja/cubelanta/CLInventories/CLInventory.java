package fr.xninja.cubelanta.CLInventories;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CLInventory implements Listener {
    public Inventory inventory;
    public Integer size;
    public Material fill;
    public String name;

    CLInventory(Integer size, Material fill, String name) {
        this.size = size;
        this.fill = fill;
        this.name = name;

        this.inventory = Bukkit.createInventory(null, this.size, this.name);
        this.initializeItems();
    }

    public void initializeItems() {
        Integer i;
        for(i = 0; i<this.size; i++) {
            this.inventory.setItem(i, new ItemStack(this.fill));
        }
    }

    public void openInventory(Player player) {
        player.openInventory(this.inventory);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent evt) {
        // Do nothing if inventory has changed
        if(!evt.getInventory().equals(this.inventory)) {
            return;
        }

        evt.setCancelled(true);

        ItemStack clickedItem = evt.getCurrentItem();
        if(clickedItem == null) {
            return;
        }

        Player p = (Player) evt.getWhoClicked();
        p.sendMessage("You clicked at slot " + evt.getRawSlot());
    }

    @EventHandler
    public void onInventoryClick(final InventoryDragEvent evt) {
        if (evt.getInventory().equals(this.inventory)) {
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
