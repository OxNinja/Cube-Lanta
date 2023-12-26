package fr.xninja.cubelanta;

import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

import fr.xninja.cubelanta.CLCommands.CLCommandInventoryAdmin;
import fr.xninja.cubelanta.CLCommands.CLCommandTeamCreate;
import fr.xninja.cubelanta.CLCommands.CLCommandTeamSetLeader;
import fr.xninja.cubelanta.CLCommands.CLCommandTeamSetMember;
import fr.xninja.cubelanta.CLCommands.CLCommandTeamShow;
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
		this.getCommand("cl-team-show").setExecutor(new CLCommandTeamShow());
		this.getCommand("cl-team-set-leader").setExecutor(new CLCommandTeamSetLeader());
		this.getCommand("cl-team-set-member").setExecutor(new CLCommandTeamSetMember());
		this.getCommand("cl-inventory-admin").setExecutor(new CLCommandInventoryAdmin());

		getLogger().info("CubeLanta is loaded!");
	}

	@Override
	public void onDisable() {
		getLogger().info("CubeLanta is unloaded.");
	}
}
