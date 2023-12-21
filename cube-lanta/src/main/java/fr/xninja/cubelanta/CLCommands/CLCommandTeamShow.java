package fr.xninja.cubelanta.CLCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.xninja.cubelanta.CLGlobal;

public class CLCommandTeamShow implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // TODO: control args length
        String teamName = args[0];
        if(CLGlobal.teams.containsKey(teamName)) {
            String message = CLGlobal.teams.get(teamName).toString();
            sender.sendMessage(message);
            return true;
        } else {
            sender.sendMessage("Team " + teamName + " not found.");
            return false;
        }
    }
}
