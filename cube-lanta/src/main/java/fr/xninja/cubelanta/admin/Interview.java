package fr.xninja.cubelanta.admin;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.xninja.cubelanta.CubeLanta;
import fr.xninja.cubelanta.utility.Utility;

public class Interview {
	public static Player _denis, _player;
	public static Location interviewDenis;
	public static Location interviewPlayer;
	public static Location denisBefore;
	public static Location playerBefore;
	public static boolean isInterviewing;

	public static void setInterviewSpot(Player denis, double x, double y, double z) {
		isInterviewing = false;
		interviewDenis = denis.getLocation();
		interviewPlayer = new Location(denis.getWorld(), x, y, z);
	}

	public static void prepareInterView(Player denis, Player player, int time) {
		// TODO: check if a test will not be running during the interview
		// TODO: check if no interview will be scheduled overlapping each other

		_denis = denis;
		_player = player;
		// Call startInterview in time minutes using BukkitRunnable and runTaskLater
		final Player d = _denis;
		final Player p = _player;
		new BukkitRunnable() {
			@Override
			public void run() {
				String m = "Let the interview begin!";
				d.sendMessage(m);
				p.sendMessage(m);
				startInterview();
			}
		}.runTaskLater(CubeLanta.getInstance(), Utility.minutesToTicks(time));

		// Send notification to both Denis and player
		Utility.sendNotification(_denis,
				"You will be interviewing " + _player.getName() + " in " + String.valueOf(time) + " min!");
		Utility.sendNotification(_player, "You will be interviewed by Denis in " + String.valueOf(time) + " min!");
	}

	public static void startInterview() {
		isInterviewing = true;
		// Save both Denis' and player's locations before the interview
		denisBefore = _denis.getLocation();
		playerBefore = _player.getLocation();

		// Teleport to interview
		_denis.teleport(interviewDenis);
		_player.teleport(interviewPlayer);
	}

	public static void stopInterview() {
		// Send notification
		Utility.sendNotification(_denis, "End of interview!");
		Utility.sendNotification(_player, "End of interview, thanks for your time!");

		// Teleport back to previous locations
		_denis.teleport(denisBefore);
		_player.teleport(playerBefore);

		isInterviewing = false;
	}

}
