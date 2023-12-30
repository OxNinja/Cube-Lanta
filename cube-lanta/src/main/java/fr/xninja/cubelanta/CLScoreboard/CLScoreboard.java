package fr.xninja.cubelanta.CLScoreboard;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class CLScoreboard {
    ScoreboardManager scoreboardManager;
	Scoreboard scoreboard;

    HashMap<String, Team> teams;

    public CLScoreboard() {
        this.scoreboardManager = Bukkit.getScoreboardManager();
        this.scoreboard = this.scoreboardManager.getMainScoreboard();
        this.teams = new HashMap<String, Team>();
    }

    // Create teams
    public void createTeam(String name) {
        Team team = scoreboard.registerNewTeam(name);
        teams.put(name, team);
    }

    public Team getTeam(String name) {
        Team team = teams.get(name);
        return team;
    }

    public void setTeam(String name, Team team) {
        teams.put(name, team);
    }

    // Add player to team
    public void setPlayer(Player player, String teamName) {
        Team team = getTeam(teamName);
        team.addPlayer(player);
    }

    public Team getPlayerTeam(Player player) {
        Team team = null;

        for(Team t : teams.values()) {
            for(String s : t.getEntries()) {
                System.out.println("Team " + t.getName() + " " + s);
            }
        }

        return team;
    }

    // Remove player from team

    // Show information to members
}
