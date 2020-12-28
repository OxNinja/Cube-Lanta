package fr.xninja.cubelanta;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.xninja.cubelanta.commands.*;
import fr.xninja.cubelanta.utility.PlayerListener;

public final class CubeLanta extends JavaPlugin {

	public static Plugin instance;

	private final PlayerListener playerListener = new PlayerListener(this);

	PluginDescriptionFile pdf = this.getDescription();

	@Override
	public void onEnable() {
		// When plugin is loaded
		instance = this;

		// Register events
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(playerListener, this);

		// Save config (default if none)

		// Register commands
		getCommand("role").setExecutor(new CommandRole());
		getCommand("setup").setExecutor(new CommandSetup());
		getCommand("setinterview").setExecutor(new CommandSetInterview());
		getCommand("interview").setExecutor(new CommandInterview());
		//
		getCommand("changeteam").setExecutor(new CommandChangeTeam());

		// Launch background thread (bukkitrunnable)

		getLogger().info(pdf.getName() + " is enabled! [v" + pdf.getVersion() + "]");
	}

	@Override
	public void onDisable() {
		// When plugin is unloaded
		getLogger().info(pdf.getName() + " is disabled :(");
	}

	public static Plugin getInstance() {
		return instance;
	}
}
