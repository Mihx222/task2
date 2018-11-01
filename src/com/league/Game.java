package com.league;

import java.text.DecimalFormat;
import java.util.ArrayList;

class Game {
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Goal> goals = new ArrayList<>();
    private String gameName = "Unnamed";

    String getGameName() { return gameName; }
    ArrayList<Team> getPlayingTeams() { return teams; }
    ArrayList<Goal> getScoredGoals() { return goals; }

    Game(Team team1, Team team2, String gameName) {
        teams.add(team1);
        teams.add(team2);
        this.gameName = gameName;
    }

    Game(Team team1, Team team2) {
        teams.add(team1);
        teams.add(team2);
    }

    void addGoal(Team team, Player player, double time) {
        Goal goal = new Goal(team, player, time);
        goals.add(goal);
        team.incrementTotalScoredGoals();
    }
}
