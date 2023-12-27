package fr.xninja.cubelanta;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

import fr.xninja.cubelanta.CLScoreboard.CLScoreboard;

public class CLGlobal {
    public static CLScoreboard scoreboard;
    public static HashMap<String, CLTeam> teams;
    public static HashMap<String, CommandExecutor> commands;
    public static ArrayList<Listener> listeners;
}
