package com.league;

import java.util.ArrayList;

public class League {
    public static void main(String[] args) {
        League iLeague = new League("International League");

        iLeague.addTeam("Reds");
        iLeague.getTeam("Reds").addPlayer("George Eliot");
        iLeague.getTeam("Reds").addPlayer("Graham Greene");
        iLeague.getTeam("Reds").addPlayer("Geoffrey Chaucer");

        iLeague.addTeam("Blues");
        iLeague.getTeam("Blues").addPlayer("Robert Service");
        iLeague.getTeam("Blues").addPlayer("Robbie Burns");
        iLeague.getTeam("Blues").addPlayer("Rafael Sabatini");

        iLeague.getTeam("Reds").printPlayers();
        System.out.println();
        iLeague.getTeam("Blues").printPlayers();
        System.out.println();

        iLeague.addGame(iLeague.getTeam("Reds"), iLeague.getTeam("Blues"), "Match No. 1");

    }

    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Game> games = new ArrayList<>();
    private String leagueName;

    ArrayList<Team> getTeams() { return teams; }

    private Team getTeam(String teamName) {
        for (Team team : teams) {
            if (team.getTeamName().toLowerCase().equals(teamName.toLowerCase()))
                return team;
        }
        throw new IllegalArgumentException("Team: " + teamName + " not found.");
    }

    ArrayList<Game> getGames() { return games; }

    Game getGame(String gameName) {
        for (Game game : games) {
            if (game.getGameName().toLowerCase().equals(gameName.toLowerCase()))
                return game;
        }
        throw new IllegalArgumentException("Game: " + gameName + " not found.");
    }

    private League(String leagueName) { this.leagueName = leagueName; }
    String getLeagueName() { return leagueName; }

    private void addTeam(String teamName) {
        Team team = new Team(teamName);
        teams.add(team);
    }

    private void addGame(Team team1, Team team2, String gameName) {
        Game game = new Game(team1, team2, gameName);
        games.add(game);
    }

    void playGame(Game gameToPlay) {

    }
}
