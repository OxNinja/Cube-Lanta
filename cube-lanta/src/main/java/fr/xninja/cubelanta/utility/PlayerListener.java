package fr.xninja.cubelanta.utility;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.xninja.cubelanta.CubeLanta;

public class PlayerListener implements Listener {

	private final CubeLanta cubelanta;

	public PlayerListener(CubeLanta inst) {
		cubelanta = inst;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		cubelanta.getLogger().info("[+] " + e.getPlayer().getName() + " joined!");
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		cubelanta.getLogger().info("[-] " + e.getPlayer().getName() + " left");
	}
	
}
