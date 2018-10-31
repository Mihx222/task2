package com.league;

import java.text.DecimalFormat;
import java.util.ArrayList;

class Game {
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Goal> goals = new ArrayList<>();
    private String gameName = "Unnamed";

    String getGameName() { return gameName; }
    ArrayList<Team> getPlayingTeams() { return teams; }

    Game(Team team1, Team team2, String gameName) {
        teams.add(team1);
        teams.add(team2);
        this.gameName = gameName;
    }

    Game(Team team1, Team team2) {
        teams.add(team1);
        teams.add(team2);
    }

    void addGoal(Team teamName, Player playerName, double time) {
        Goal goal = new Goal(teamName, playerName, time);
        goals.add(goal);
    }

    void printStatistics() {
        System.out.println("Match: " + gameName);
        System.out.println(teams.get(0).getTeamName() + " V/S " + teams.get(1).getTeamName());
        System.out.println("Goals:");
        // Print goals (if any) with formatted time, player who scored and team name
        if (goals.size() == 0)
            System.out.println("No goals have been scored.");
        else
            for (Goal goal : goals) {
                System.out.println("Goal scored after " +
                        new DecimalFormat("#.#").format(goal.getTime()) +
                        " minutes, by " + goal.getPlayer().getName() +
                        ", from " + goal.getTeam().getTeamName());
            }
    }
}
