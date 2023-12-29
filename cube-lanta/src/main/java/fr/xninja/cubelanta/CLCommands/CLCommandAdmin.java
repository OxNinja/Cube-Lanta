package fr.xninja.cubelanta.CLCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.xninja.cubelanta.CLGlobal;

public class CLCommandAdmin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = Bukkit.getPlayer(sender.getName());
        if(player != null) {
            player.getInventory().addItem(CLGlobal.adminItem);
            player.sendMessage("Here you go.");
            return true;
        }
        return false;
    }
}
