package com.league;

import java.util.ArrayList;
import java.util.Iterator;

class Team {
    private ArrayList<Player> players = new ArrayList<>();
    private String team_name = "Unknown";

    Team(String team_name) { this.team_name = team_name; }
    Team() {}

    void add(String player_name) {
        Player player = new Player(player_name);
        players.add(player);
    }

    void remove(String player_name) {
        Iterator itr = players.iterator();
        while (itr.hasNext()) {
            Player temp = (Player)itr.next();
            if (temp.get_name().equals(player_name)) {
                System.out.println("Removed player: " + temp.get_name());
                itr.remove();
                return;
            }
        }
        System.out.println("Player: " + player_name + ", not found.");
    }

    void print() {
        System.out.println("Team: " + team_name);
        for (Player player : players)
            System.out.println(player.get_name());
    }

    String get_team_name() { return team_name; }
}
