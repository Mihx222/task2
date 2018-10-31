package com.league;

class Goal {
    private Team teamThatScored;
    private Player playerWhoScored;
    private double time;

    Goal(Team team, Player player, double time) {
        teamThatScored = team;
        playerWhoScored = player;
        this.time = time;
    }

    Team getTeam() { return teamThatScored; }
    Player getPlayer() { return playerWhoScored; }
    double getTime() { return time; }
}
