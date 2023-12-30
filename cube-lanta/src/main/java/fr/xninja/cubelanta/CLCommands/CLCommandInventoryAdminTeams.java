package fr.xninja.cubelanta.CLCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.xninja.cubelanta.CLGlobal;

public class CLCommandInventoryAdminTeams implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        CLGlobal.inventories.get("admin-teams").openInventory(Bukkit.getPlayer(sender.getName()));
        return true;
    }

}
