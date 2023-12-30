package fr.xninja.cubelanta.CLCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.xninja.cubelanta.CLGlobal;
import fr.xninja.cubelanta.CLTeam;
import fr.xninja.cubelanta.CLInventories.CLInventory;
import fr.xninja.cubelanta.CLInventories.CLInventoryTeamManage;

public class CLCommandTeamCreate implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // /cl-create-team team_name
        String teamName = args[0];

        if(CLGlobal.teams.containsKey(teamName)) {
            sender.sendMessage("This team already exists");
            return false;
        }

        CLTeam team = new CLTeam(teamName);
        CLGlobal.teams.put(teamName, team);

        CLInventory inventory = new CLInventoryTeamManage(team);
        CLGlobal.inventories.put("team-manage-" + teamName, inventory);
        CLGlobal.listeners.add(inventory);

        sender.sendMessage("Created the team " + teamName);
        return true;
    }
}
