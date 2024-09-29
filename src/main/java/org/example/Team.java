package org.example;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int id;
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    // Add a player to the team
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
