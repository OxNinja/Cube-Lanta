package fr.xninja.cubelanta.utility;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.xninja.cubelanta.team.*;

public class Utility {

	public static void setup(CommandSender p, String yellow, String red, String white) {
		TeamInitiate.createTeams(yellow, red, white);

		p.sendMessage("Teams " + yellow + ", " + red + " and " + white + " have been created");
	}

	public static void sendNotification(Player p, String m) {
		// Send a nice notification to a player
		p.sendMessage(m);
	}

	public static long minutesToTicks(int m) {
		return 20 * 60 * m;
	}

	public static String ticksToTimeString(int t) {
		int MS = 20, S = MS * 60, M = S * 60, H = M * 24, D = H * 365;
		int y, d, h, m, s, ms;
		String time = "";
		ms = t % MS;
		t = t / MS;
		s = t % S;
		t = t / S;
		m = t % M;
		t = t / M;
		h = t % H;
		t = t / H;
		d = t % D;
		t = t / D;
		y = t;

		if (y > 0) {
			time = time.concat(String.valueOf(y) + "y ");
		}
		if (d > 0) {
			time = time.concat(String.valueOf(d) + "d ");
		}
		if (h > 0) {
			time = time.concat(String.valueOf(h) + "h ");
		}
		if (m > 0) {
			time = time.concat(String.valueOf(m) + "m ");
		}
		if (s > 0) {
			time = time.concat(String.valueOf(s) + "s ");
		}
		if (ms > 0) {
			time = time.concat(String.valueOf(ms) + "ms");
		}

		return time;
	}

}
