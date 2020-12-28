package fr.xninja.cubelanta.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.xninja.cubelanta.admin.Interview;

public class CommandInterview implements CommandExecutor {
	
	public boolean onCommand(CommandSender p, Command c, String s, String[] args) {
		if (!args[0].equals("start") && !args[0].equals("stop")) {
			return false;
		} else {
			if (args[0].equals("start")) {
				if (args.length !=  4) {
					return false;
				}
				String player = args[1];
				int time = Integer.parseInt(args[2]);
				// Check if player is online
				Player interviewed = Bukkit.getPlayer(player);
				if (Bukkit.getOnlinePlayers().contains(interviewed)) {
					if (time >= 1 && time <= 10) {
						Interview.prepareInterView((Player) p, interviewed, time);
					} else {
						p.sendMessage("Time " + args[2] + " is not a valid number of minutes, must be between 1 and 10.");
					}
				} else {
					p.sendMessage("Player " + args[1] + " not found, maybe offline?");
				}
			} else if (args[0].equals("stop")) {
				if (Interview.isInterviewing) {
					Interview.stopInterview();
				} else {
					p.sendMessage("You are not interviewing someone.");
				}
			}
			return true;
		}
	}

}
