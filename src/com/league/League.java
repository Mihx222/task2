package com.league;

import java.util.ArrayList;
import java.util.Random;

public class League {
    public static void main(String[] args) {
        // Create new league
        League iLeague = new League("International League");

        // Add a team with players to the league
        iLeague.addTeam("Reds");
        iLeague.getTeam("Reds").addPlayer("George Eliot");
        iLeague.getTeam("Reds").addPlayer("Graham Greene");
        iLeague.getTeam("Reds").addPlayer("Geoffrey Chaucer");

        // Add a team with players to the league
        iLeague.addTeam("Blues");
        iLeague.getTeam("Blues").addPlayer("Robert Service");
        iLeague.getTeam("Blues").addPlayer("Robbie Burns");
        iLeague.getTeam("Blues").addPlayer("Rafael Sabatini");

        iLeague.getTeam("Reds").printPlayers();
        System.out.println();
        iLeague.getTeam("Blues").printPlayers();
        System.out.println();

        // Create and simulate a league game
        iLeague.addGame(iLeague.getTeam("Reds"), iLeague.getTeam("Blues"), "Match No. 1");
        System.out.println(iLeague.getGame("Match No. 1").getGameName());
        iLeague.playGame(iLeague.getGame("match no. 1"));
        iLeague.getGame("match no. 1").printStatistics();
    }

    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Game> games = new ArrayList<>();
    private String leagueName;

    ArrayList<Team> getTeams() { return teams; }

    // Get instance of Team object by teamName
    private Team getTeam(String teamName) {
        for (Team team : teams) {
            if (team.getTeamName().toLowerCase().equals(teamName.toLowerCase()))
                return team;
        }
        throw new IllegalArgumentException("Team: " + teamName + " not found.");
    }

    ArrayList<Game> getGames() { return games; }

    // Get instance of Game object by gameName
    private Game getGame(String gameName) {
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

    // Simulate a game
    private void playGame(Game gameToPlay) {
        // Random engine with seed
        Random rand = new Random(System.currentTimeMillis());

        // Generate random amount of goals, up to 3 goals per game
        int nGoals = rand.nextInt(4);

        // Generate random team index, only 2 teams can play at a time
        int teamIndex = rand.nextInt(2);

        // Generate random player index
        int playerIndex = gameToPlay.getPlayingTeams().get(teamIndex).getPlayers().size() - 1;

        // Generate random time, up to 90 minutes per game
        double randomTime = 90 * rand.nextDouble();

        for (int i = 0; i < nGoals; i++) {
            // Add a goal
            gameToPlay.addGoal(gameToPlay.getPlayingTeams().get(teamIndex),
                    gameToPlay.getPlayingTeams().get(teamIndex).getPlayers().get(playerIndex),
                    randomTime);

            // Reinitialize random variables
            teamIndex = rand.nextInt(2);
            playerIndex = rand.nextInt(gameToPlay.getPlayingTeams().get(teamIndex).getPlayers().size());
            randomTime = randomTime + (90 - randomTime) * rand.nextDouble();
        }
    }
}
