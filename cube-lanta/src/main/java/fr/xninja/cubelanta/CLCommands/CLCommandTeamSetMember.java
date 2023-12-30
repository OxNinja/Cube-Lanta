package fr.xninja.cubelanta.CLCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.xninja.cubelanta.CLGlobal;

public class CLCommandTeamSetMember implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // TODO: control args length
        String teamName = args[0];
        String memberName = args[1];
        String message = "";
        if(CLGlobal.teams.containsKey(teamName)) {
            Boolean result = CLGlobal.teams.get(teamName).addMember(Bukkit.getPlayer(memberName));
            if(result) {
                message = memberName + " is now a member of team " + teamName;
            } else {
                message = "Error while adding player " + memberName + " to team " + teamName + ". Maybe the player is already in this team, or the player does not exists.";
            }
            sender.sendMessage(message);
            return result;
        } else {
            sender.sendMessage("Team " + teamName + " does not exist.");
            return false;
        }
    }
}
