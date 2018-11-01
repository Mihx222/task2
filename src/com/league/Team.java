package com.league;

import java.util.ArrayList;

class Team {
    private ArrayList<Player> players = new ArrayList<>();
    private String teamName;
    private int totalGoalsScored = 0;

    Team(String teamName) { this.teamName = teamName; }

    ArrayList<Player> getPlayers() { return players; }
    String getTeamName() { return teamName; }
    int getTotalGoalsScored() { return totalGoalsScored; }

    void addPlayer(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
    }

    void incrementTotalScoredGoals() { totalGoalsScored++; }

    void remove(Player playerInst) {
        ArrayList<Player> playersToRemove = new ArrayList<>();
        for (Player player : players) {
            if (player.getName().equals(playerInst.getName()))
                playersToRemove.add(playerInst);
        }
        players.removeAll(playersToRemove);
    }

    void printPlayers() {
        System.out.println("Team: " + teamName);
        for (Player player : players) {
            player.reverseName();
            System.out.println(player.getName());
        }
    }

    ArrayList<String> find(String subName) {
        ArrayList<String> names = new ArrayList<>();
        for (Player player : players) {
            if (player.getName().toLowerCase().contains(subName.toLowerCase()))
                names.add(player.getName());
        }
        return names;
    }
}
