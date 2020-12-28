package fr.xninja.cubelanta.team;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class TeamInitiate {

	public static void createTeams(String yellow, String red, String white) {
		// Create all teams in a scoreboard
		ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard s = sm.getNewScoreboard();

		Team yellows = s.registerNewTeam(yellow);
		setupTeam(yellows, ChatColor.YELLOW);
		Team reds = s.registerNewTeam(red);
		setupTeam(reds, ChatColor.RED);
		Team whites = s.registerNewTeam(white);
		setupTeam(whites, ChatColor.WHITE);
		Team denis = s.registerNewTeam("Denis");
		setupTeam(denis, ChatColor.GREEN);
		Team cameramen = s.registerNewTeam("Cameraman");
		setupTeam(cameramen, ChatColor.GRAY);

		updatePlayersScoreboard(s);
	}

	public static void setupTeam(Team t, ChatColor c) {
		t.setPrefix(c + "" + t.getName() + " ");
		t.setAllowFriendlyFire(false);
	}

	public static void updatePlayersScoreboard(Scoreboard score) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.setScoreboard(score);
		}
	}
	
}
