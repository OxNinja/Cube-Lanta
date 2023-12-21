package fr.xninja.cubelanta.CLCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.xninja.cubelanta.CLGlobal;
import fr.xninja.cubelanta.CLTeam;

public class CLCommandTeamsList implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String message = "Teams:";

        for(CLTeam team: CLGlobal.teams.values()) {
            message += "\n" + team.name;
        }

        sender.sendMessage(message);
        return true;
    }
}
