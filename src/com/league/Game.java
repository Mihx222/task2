package com.league;

import java.util.ArrayList;

class Game {
    private Team team1, team2;
    private ArrayList<Goal> goals = new ArrayList<>();
    private String game_name = "Unnamed";

    Game(Team team1, Team team2, String game_name) {
        this.team1 = team1;
        this.team2 = team2;
        this.game_name = game_name;
    }

    Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    void add_goal(String team_name, String player_name, double time) {
        Goal goal = new Goal(team_name, player_name, time);
        goals.add(goal);
    }

    void print_statistics() {
        System.out.println("Match: " + game_name);
        System.out.println(team1.get_team_name() + " V/S " + team2.get_team_name());
        System.out.println("Goals:");
        for (Goal goal : goals) {
            System.out.println("Goal scored after " + goal.get_time() +
                    ", by " + goal.get_player() + ", from " + goal.get_team());
        }
    }
}
