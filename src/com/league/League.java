package com.league;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class League {
    public static void main(String[] args) {
//        Create new league
        League iLeague = new League("International League");

//        Add a team with players to the league
        iLeague.addTeam("Reds");
        iLeague.getLeagueTeam("Reds").addPlayer("George Eliot");
        iLeague.getLeagueTeam("Reds").addPlayer("Graham Greene");
        iLeague.getLeagueTeam("Reds").addPlayer("Geoffrey Chaucer");

//        Add a team with players to the league
        iLeague.addTeam("Blues");
        iLeague.getLeagueTeam("Blues").addPlayer("Robert Service");
        iLeague.getLeagueTeam("Blues").addPlayer("Robbie Burns");
        iLeague.getLeagueTeam("Blues").addPlayer("Rafael Sabatini");

//        iLeague.getLeagueTeam("Reds").printPlayers();
//        System.out.println();
//        iLeague.getLeagueTeam("Blues").printPlayers();
//        System.out.println();

//        Create league games
        iLeague.addGame(iLeague.getLeagueTeam("Reds"),
                iLeague.getLeagueTeam("Blues"), "Match No. 1");
        iLeague.addGame(iLeague.getLeagueTeam("Reds"),
                iLeague.getLeagueTeam("Blues"), "Match No. 2");
        iLeague.addGame(iLeague.getLeagueTeam("Reds"),
                iLeague.getLeagueTeam("Blues"), "Match No. 3");
        iLeague.addGame(iLeague.getLeagueTeam("Reds"),
                iLeague.getLeagueTeam("Blues"), "Match No. 4");

//        Simulate league games
        gameUtils.playGame(iLeague.getGame("match no. 1"));
        gameUtils.playGame(iLeague.getGame("match no. 2"));
        gameUtils.playGame(iLeague.getGame("match no. 3"));
        gameUtils.playGame(iLeague.getGame("match no. 4"));

        iLeague.printStatistics();
    }

    private ArrayList<Team> leagueTeams = new ArrayList<>();
    private ArrayList<Game> games = new ArrayList<>();
    private String leagueName;

    private League(String leagueName) { this.leagueName = leagueName; }

    ArrayList<Team> getLeagueTeams() { return leagueTeams; }
    ArrayList<Game> getGames() { return games; }
    private String getLeagueName() { return leagueName; }

//    Get instance of Team object by teamName
    private Team getLeagueTeam(String teamName) {
        for (Team team : leagueTeams) {
            if (team.getTeamName().toLowerCase().equals(teamName.toLowerCase()))
                return team;
        }
        throw new IllegalArgumentException("Team: " + teamName + " not found.");
    }

//    Get instance of Game object by gameName
    private Game getGame(String gameName) {
        for (Game game : games) {
            if (game.getGameName().toLowerCase().equals(gameName.toLowerCase()))
                return game;
        }
        throw new IllegalArgumentException("Game: " + gameName + " not found.");
    }

    private void addTeam(String teamName) {
        Team team = new Team(teamName);
        leagueTeams.add(team);
    }

    private void addGame(Team team1, Team team2, String gameName) {
        Game game = new Game(team1, team2, gameName);
        games.add(game);
    }

    private void printStatistics() {
        System.out.println(leagueName);
        System.out.println();
        for (Game game : games) {
            System.out.println(game.getPlayingTeams().get(0).getTeamName() + " V/S " +
                    game.getPlayingTeams().get(1).getTeamName());
            System.out.println("Scored goals:");

            if (game.getScoredGoals().size() == 0)
                System.out.println("No goals have been scored.");
            else {
                for (Goal goal : game.getScoredGoals()) {
                    System.out.println("Goal scored after " +
                            new DecimalFormat("#.#").format(goal.getTime()) +
                            " minutes, by " + goal.getPlayer().getName() +
                            ", from " + goal.getTeam().getTeamName());
                }
            }
            System.out.println();
            System.out.println("Total goals scored by " + game.getPlayingTeams().get(0).getTeamName() +
                    ": " + game.getPlayingTeams().get(0).getTotalGoalsScored());
            System.out.println("Total goals scored by " + game.getPlayingTeams().get(1).getTeamName() +
                    ": " + game.getPlayingTeams().get(0).getTotalGoalsScored());
        }
    }
}
