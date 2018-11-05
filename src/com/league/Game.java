package com.league;

import java.util.ArrayList;

class Game {
    private Team team1, team2;
    private ArrayList<Goal> team1Goals = new ArrayList<>();
    private ArrayList<Goal> team2Goals = new ArrayList<>();
    private Team winner;
    private String gameName;

    String getGameName() { return gameName; }

    Team getTeam1() {
        return team1;
    }

    Team getTeam2() {
        return team2;
    }

    Team getTeam(int index) {
        if (index == 0)
            return team1;
        else if (index == 1)
            return team2;
        else
            throw new ArrayIndexOutOfBoundsException("Invalid index!");
    }

    ArrayList<Goal> getScoredGoals(Team team) {
        if (team1.getTeamName().equals(team.getTeamName()))
            return team1Goals;
        else if (team2.getTeamName().equals(team.getTeamName()))
            return team2Goals;
        else
            throw new IllegalArgumentException("Team " + team.getTeamName() + " not found.");
    }

    ArrayList<Goal> getTotalScoredGoals() {
        ArrayList<Goal> allGoals = new ArrayList<>(team1Goals);
        allGoals.addAll(team2Goals);
        return allGoals;
    }

    Team getWinner() {
        return winner;
    }

    void setWinner(Team winner) {
        this.winner = winner;
    }

    Game(Team team1, Team team2, String gameName) {
        this.team1 = new Team(team1);
        this.team2 = new Team(team2);
        this.gameName = gameName;
    }

    void addGoal(Team team, Player player, double time) {
        Goal goal = new Goal(team, player, time);
        if (team1.getTeamName().equals(team.getTeamName())) {
            team1Goals.add(goal);
            team1.incrementTotalScoredGoals();
        }
        else if (team2.getTeamName().equals(team.getTeamName())) {
            team2Goals.add(goal);
            team2.incrementTotalScoredGoals();
        }
    }
}
