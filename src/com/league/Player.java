package com.league;

class Player {
    private String name;
    Player(String name) { this.name = name; }
    String getName() { return name; }
    void setName(String playerName) { this.name = playerName; }

    void reverseName() {
        String split[] = name.split(" ");
        name = split[1] + " " + split[0];
    }
}