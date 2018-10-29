package com.league;

class Player {
    private String name;
    Player(String name) { this.name = name; }
    String get_name() { return name; }

    void reverse_name() {
        String split[] = name.split(" ");
        name = split[1] + " " + split[0];
    }
}