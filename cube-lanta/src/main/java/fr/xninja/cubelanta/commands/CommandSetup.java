package fr.xninja.cubelanta.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.xninja.cubelanta.utility.*;

public class CommandSetup implements CommandExecutor {

	public boolean onCommand(CommandSender p, Command c, String s, String[] args) {

		if (args.length != 3) {
			p.sendMessage("Usage: /setup <yellow team name> <red team name> <white team name>");
			return false;
		} else {
			p.sendMessage("OK man");
			Utility.setup(p, args[0], args[1], args[2]);
			return true;
		}
	}

}
