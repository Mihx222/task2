package com.league;

public class League {
    public static void main(String[] args) {
        Team Reds = new Team("Reds");
        Reds.add("George Eliot");
        Reds.add("Graham Greene");
        Reds.add("Geoffrey Chaucer");

        Team Blues = new Team("Blues");
        Blues.add("Robert Service");
        Blues.add("Robbie Burns");
        Blues.add("Rafael Sabatini");

        Reds.print();
        System.out.println();
        Blues.print();

        Game match1 = new Game(Reds, Blues, "Match No.1");
        match1.addGoal(Reds.getTeamName(), Reds.getPlayer(0), 13.8);
        match1.addGoal(Blues.getTeamName(), Blues.getPlayer(1), 22.4);
        match1.addGoal(Reds.getTeamName(), Reds.getPlayer(2), 55.0);

        System.out.println();
        match1.printStatistics();
        System.out.println();
        System.out.println(Reds.find("auc"));
    }
}
