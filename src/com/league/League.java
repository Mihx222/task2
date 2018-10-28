package com.league;

public class League {
    public static void main(String[] args) {
        Team Reds = new Team("Reds");
        Reds.add("Tom");
        Reds.add("Bob");
        Reds.add("Tim");

        Team Blues = new Team("Blues");
        Blues.add("Greg");
        Blues.add("Jordan");
        Blues.add("Stephan");

        Reds.print();
        System.out.println();
        Blues.print();

        Game match1 = new Game(Reds, Blues, "Match No.1");
        match1.add_goal(Reds.get_team_name(), "Tom", 13.8);
        match1.add_goal(Blues.get_team_name(), "Jordan", 22.4);
        match1.add_goal(Reds.get_team_name(), "Bob", 55.0);

        System.out.println();
        match1.print_statistics();
    }
}
