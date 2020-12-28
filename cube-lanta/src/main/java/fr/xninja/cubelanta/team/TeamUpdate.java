package fr.xninja.cubelanta.team;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TeamUpdate {

	public static void changeTeam(Player p, String t) {
		Scoreboard s = p.getScoreboard();
		try {
			// Remove player from old team
			Team oldTeam = s.getEntryTeam(p.getName());
			oldTeam.removeEntry(p.getName());
			// Add player to new team
			Team newTeam = s.getTeam(t);
			newTeam.addEntry(p.getName());
		} catch (Exception e) {
			Bukkit.getServer().getLogger().info(e.toString());
		}
	}
	
}
