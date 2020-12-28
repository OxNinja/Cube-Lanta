package fr.xninja.cubelanta.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.xninja.cubelanta.admin.Interview;

public class CommandSetInterview implements CommandExecutor {

	public boolean onCommand(CommandSender p, Command c, String s, String[] args) {

		if (args.length != 3) {
			p.sendMessage("Usage: /setinterview <interviewedX> <interviewedY> <interviewedZ>");
			return false;
		} else {
			p.sendMessage("OK man");
			double x = Double.parseDouble(args[0]);
			double y = Double.parseDouble(args[1]);
			double z = Double.parseDouble(args[2]);
			if (y >= 1 && y <= 255) {
				Interview.setInterviewSpot((Player) p, x, y, z);
			} else {
				p.sendMessage("You must enter valid X, Y and Z coordinates for the interviewed player's position.");
			}
			
			return true;
		}
	}

}
