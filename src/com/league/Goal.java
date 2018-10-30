package com.league;

class Goal {
    private String teamThatScored;
    private String playerWhoScored;
    private double time;

    Goal(String teamName, String playerName, double time) {
        teamThatScored = teamName;
        playerWhoScored = playerName;
        this.time = time;
    }

    String getTeam() { return teamThatScored; }
    String getPlayer() { return playerWhoScored; }
    double getTime() { return time; }
}
