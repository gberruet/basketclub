package org.example;

public class Player {
    private int id;
    private String name;
    private int jerseyNumber;

    public Player(String name, int jerseyNumber) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }
}

