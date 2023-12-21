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

    public void addMember(Player member) {
        this.members.add(member);
    }

    public void removeMember(Player member) {
        int index = this.members.indexOf(member);
        if(index == -1) {
            System.out.println("Member " + member.getName() + " not found in team " + this.name + " for remove.");
        } else {
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
        String resutl = "===== " + this.name + " =====\n";
        String leaderName = "";
        if(this.getLeader() != null) {
            leaderName = this.getLeader().getName();
        }
        resutl += "Leader: " + leaderName + "\n";
        resutl += "Members: (" + String.valueOf(this.members.size()) + ")\n";
        for(Player p: this.getMembers()) {
            resutl += p.getName() + "\n";
        }

        return resutl;
    }
}
