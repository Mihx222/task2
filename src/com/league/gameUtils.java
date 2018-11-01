package com.league;

import java.util.Random;

class gameUtils {
    // Simulate a game
    static void playGame(Game gameToPlay) {
        // Random engine with seed
        Random rand = new Random();

        // Generate random amount of goals, up to 4 goals per game
        int nGoals = rand.nextInt(5);

        // Generate random team index, only 2 leagueTeams can play at a time
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
