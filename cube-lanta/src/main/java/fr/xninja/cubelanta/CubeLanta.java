package fr.xninja.cubelanta;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class CubeLanta extends JavaPlugin {

	public static Plugin instance;

	PluginDescriptionFile pdf = this.getDescription();

	@Override
	public void onEnable() {
		getLogger().info("CubeLanta is loaded!");
	}

	@Override
	public void onDisable() {
		getLogger().info("CubeLanta is unloaded.");
	}
}
