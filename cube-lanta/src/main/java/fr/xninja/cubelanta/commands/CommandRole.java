package fr.xninja.cubelanta.commands;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Iterator;
import java.util.Set;

public class CommandRole implements CommandExecutor {

	public boolean onCommand(CommandSender p, Command c, String s, String[] args) {

		if (args.length >= 1) {
			// /role <role> set <player(s)>
			if (args.length == 1) {
				// /role <player>
				if (p.hasPermission("command.role")) {
					String role = "";
					Player target = Bukkit.getPlayer(args[0]);
					Set<Team> teams = target.getScoreboard().getTeams();
					Iterator i = teams.iterator();
					while (i.hasNext()) {
						role = role.concat((String) i.next());
					}
					p.sendMessage("Player " + target + " have the role: " + role);
				} else {
					p.sendMessage("You don't have the permission command.role");
				}
			}

			return true;
		} else {
			return false;
		}

	}

}
