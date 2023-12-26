package fr.xninja.cubelanta;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class CLTeam {
    public String name;
    public List<Player> members;
    public Player leader;
    // Base/island
    // Color

    public CLTeam(String name) {
        this.name = name;
        this.members = new ArrayList<Player>();
    }

    public List<Player> getMembers() {
        return this.members;
    }

    public void setMembers(List<Player> list) {
        this.members = list;
    }

    public Boolean addMember(Player member) {
        Boolean result = false;

        if(this.members.contains(member)) {
            System.out.println("Player " + member.getName() + " is already in this team");
            return result;
        }

        for(CLTeam team: CLGlobal.teams.values()) {
            if(team.members.contains(member)) {
                System.out.println("Player " + member.getName() + " is in another team: " + team.name);
                team.removeMember(member);
            }
        }

        result = true;
        this.members.add(member);
        System.out.println("Player " + member.getName() + " has been added to team " + this.name);
        return result;
    }

    public void removeMember(Player member) {
        int index = this.members.indexOf(member);
        if(index == -1) {
            System.out.println("Player " + member.getName() + " not found in team " + this.name + " for remove.");
        } else {
            System.out.println("Player " + member.getName() + " has been removed from team " + this.name);
            this.members.remove(index);
        }
    }

    public Player getLeader() {
        return this.leader;
    }

    public void setLeader(Player member) {
        if(this.leader != null && this.leader.equals(member)) {
            System.out.println(member.getName() + "is already the leader.");
            return;
        }

        int index = this.members.indexOf(member);
        if(index == -1) {
            System.out.println("Member " + member.getName() + " not found in team " + this.name + ". Adding to team.");
            addMember(member);
        }

        this.leader = member;
    }

    @Override
    public String toString() {
        String result = "===== " + this.name + " =====\n";
        String leaderName = "";
        if(this.getLeader() != null) {
            leaderName = this.getLeader().getName();
        }
        result += "Leader: " + leaderName + "\n";
        result += "Members: (" + String.valueOf(this.members.size()) + ")\n";
        if(this.members.size() > 0) {
            for(Player p: this.getMembers()) {
                result += p.getName() + "\n";
            }
        }
        return result;
    }
}
