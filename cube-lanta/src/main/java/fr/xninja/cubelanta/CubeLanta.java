package fr.xninja.cubelanta;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

import fr.xninja.cubelanta.CLCommands.CLCommandAdmin;
import fr.xninja.cubelanta.CLCommands.CLCommandInventoryAdmin;
import fr.xninja.cubelanta.CLCommands.CLCommandTeamCreate;
import fr.xninja.cubelanta.CLCommands.CLCommandTeamSetLeader;
import fr.xninja.cubelanta.CLCommands.CLCommandTeamSetMember;
import fr.xninja.cubelanta.CLCommands.CLCommandTeamShow;
import fr.xninja.cubelanta.CLCommands.CLCommandTeamsList;
import fr.xninja.cubelanta.CLInventories.CLInventory;
import fr.xninja.cubelanta.CLInventories.CLInventoryAdmin;
import fr.xninja.cubelanta.CLInventories.CLInventoryAdminTeams;
import fr.xninja.cubelanta.CLInventories.CLInventoryTeamsList;
import fr.xninja.cubelanta.CLScoreboard.CLScoreboard;

public final class CubeLanta extends JavaPlugin {
	@Override
	public void onEnable() {
		CLGlobal.plugin = this;
		CLGlobal.adminItem = CLInventory.createGuiItem(Material.COMPASS, "CubeLanta admin tools", "Right click while holding me");

		// Setup scoreboard
		CLGlobal.scoreboard = new CLScoreboard();

		// Setup teams
		CLGlobal.teams = new HashMap<String, CLTeam>();

		// Setup inventories
		CLGlobal.inventories = new HashMap<String, CLInventory>();
		CLGlobal.inventories.put("admin", new CLInventoryAdmin());
		CLGlobal.inventories.put("admin-teams", new CLInventoryAdminTeams());
		CLGlobal.inventories.put("teams-list", new CLInventoryTeamsList());

		// Setup commands
		CLGlobal.commands = new HashMap<String, CommandExecutor>();
		// TODO: find a better way to do so
		CLGlobal.commands.put("cl-team-create", new CLCommandTeamCreate());
		CLGlobal.commands.put("cl-teams-list", new CLCommandTeamsList());
		CLGlobal.commands.put("cl-team-show", new CLCommandTeamShow());
		CLGlobal.commands.put("cl-team-set-leader", new CLCommandTeamSetLeader());
		CLGlobal.commands.put("cl-team-set-member", new CLCommandTeamSetMember());
		CLGlobal.commands.put("cl-inventory-admin", new CLCommandInventoryAdmin());
		CLGlobal.commands.put("cl-admin", new CLCommandAdmin());

		for(String cmd: CLGlobal.commands.keySet()) {
			getCommand(cmd).setExecutor(CLGlobal.commands.get(cmd));
		}

		// Register events
		CLGlobal.listeners = new ArrayList<Listener>();
		CLGlobal.listeners.add(new CLListener());
		// TODO: find a better way to do so
		// refacto with only one listener CLInventory
		// and check on event for inventory name
		// will be one big function but might be better
		for(Listener listener: CLGlobal.inventories.values()) {
			CLGlobal.listeners.add(listener);
		}

		for(Listener listener: CLGlobal.listeners) {
			getServer().getPluginManager().registerEvents(listener, this);
		}

		getLogger().info("CubeLanta is loaded!");
	}

	@Override
	public void onDisable() {
		getLogger().info("CubeLanta is unloaded.");
	}
}
