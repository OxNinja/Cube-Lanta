package fr.xninja.cubelanta.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.xninja.cubelanta.team.*;

public class CommandChangeTeam implements CommandExecutor {

	public boolean onCommand(CommandSender p, Command c, String s, String[] args) {

		if (args.length != 1) {
			p.sendMessage("Usage: /changeteam <team>");
			return false;
		} else {
			TeamUpdate.changeTeam((Player) p, args[0]);
			p.sendMessage("Team changed");
			return true;
		}
	}

}
