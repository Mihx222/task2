package com.league;

class Player {
    private String name;
    Player(String name) { this.name = name; }
    String getName() { return name; }

    void reverseName() {
        String split[] = name.split(" ");
        name = split[1] + " " + split[0];
    }
}