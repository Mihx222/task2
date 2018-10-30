package com.league;

import java.util.ArrayList;
import java.util.Iterator;

class Team {
    private ArrayList<Player> players = new ArrayList<>();
    private String teamName;

    Team(String teamName) { this.teamName = teamName; }

    void add(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
    }

    void remove(String playerName) {
        Iterator itr = players.iterator();
        while (itr.hasNext()) {
            Player temp = (Player)itr.next();
            if (temp.getName().equals(playerName)) {
                System.out.println("Removed player: " + temp.getName());
                itr.remove();
                return;
            }
        }
        System.out.println("Player: " + playerName + ", not found.");
    }

    String getPlayer(int index) {
        return players.get(index).getName();
    }

    void print() {
        System.out.println("Team: " + teamName);
        for (Player player : players) {
            player.reverseName();
            System.out.println(player.getName());
        }
    }

    String getTeamName() { return teamName; }

    ArrayList<String> find(String subName) {
        ArrayList<String> names = new ArrayList<>();
        for (Player player : players) {
            if (player.getName().toLowerCase().contains(subName.toLowerCase()))
                names.add(player.getName());
        }
        return names;
    }
}
