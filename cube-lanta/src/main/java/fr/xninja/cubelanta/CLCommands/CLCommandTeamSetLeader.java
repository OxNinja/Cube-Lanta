package fr.xninja.cubelanta.CLCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.xninja.cubelanta.CLGlobal;

public class CLCommandTeamSetLeader implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // TODO: control args length
        String teamName = args[0];
        String leaderName = args[1];
        if(CLGlobal.teams.containsKey(teamName)) {
            CLGlobal.teams.get(teamName).setLeader(Bukkit.getPlayer(leaderName));
            sender.sendMessage(leaderName + " is now the leader for team " + teamName);
            return true;
        } else {
            sender.sendMessage("Team " + teamName + " does not exist.");
            return false;
        }
    }
}
