package fr.xninja.cubelanta.CLCommands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.xninja.cubelanta.CLInventories.CLInventoryAdmin;

public class CLCommandInventoryAdmin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        CLInventoryAdmin inventory = new CLInventoryAdmin(9, Material.AIR, "Admin management");
        inventory.openInventory(Bukkit.getPlayer(sender.getName()));
        return true;
    }
}
