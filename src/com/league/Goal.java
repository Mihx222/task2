package com.league;

class Goal {
    private String team_that_scored;
    private String player_who_scored;
    private double time;

    Goal(String team_name, String player_name, double time) {
        team_that_scored = team_name;
        player_who_scored = player_name;
        this.time = time;
    }

    String get_team() { return team_that_scored; }
    String get_player() { return player_who_scored; }
    double get_time() { return time; }
}
