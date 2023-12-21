package fr.xninja.cubelanta;

import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

import fr.xninja.cubelanta.CLCommands.CLCommandTeamCreate;
import fr.xninja.cubelanta.CLCommands.CLCommandTeamsList;
import fr.xninja.cubelanta.CLScoreboard.CLScoreboard;

public final class CubeLanta extends JavaPlugin {
	@Override
	public void onEnable() {
		// Setup scoreboard
		CLGlobal.scoreboard = new CLScoreboard();

		// Setup teams
		CLGlobal.teams = new HashMap<String, CLTeam>();

		// Setup commands
		this.getCommand("cl-team-create").setExecutor(new CLCommandTeamCreate());
		this.getCommand("cl-teams-list").setExecutor(new CLCommandTeamsList());

		getLogger().info("CubeLanta is loaded!");
	}

	@Override
	public void onDisable() {
		getLogger().info("CubeLanta is unloaded.");
	}
}
