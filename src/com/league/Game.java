package com.league;

import java.util.ArrayList;

class Game {
    private Team team1, team2;
    private ArrayList<Goal> goals = new ArrayList<>();
    private String gameName = "Unnamed";

    Game(Team team1, Team team2, String gameName) {
        this.team1 = team1;
        this.team2 = team2;
        this.gameName = gameName;
    }

    Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    void addGoal(String teamName, String playerName, double time) {
        Goal goal = new Goal(teamName, playerName, time);
        goals.add(goal);
    }

    void printStatistics() {
        System.out.println("Match: " + gameName);
        System.out.println(team1.getTeamName() + " V/S " + team2.getTeamName());
        System.out.println("Goals:");
        for (Goal goal : goals) {
            System.out.println("Goal scored after " + goal.getTime() +
                    ", by " + goal.getPlayer() + ", from " + goal.getTeam());
        }
    }
}
