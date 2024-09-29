package org.example;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private int id;
    private String name;
    private List<Team> teams;
    private List<Game> games;

    public Tournament(String name) {
        this.name = name;
        this.teams = new ArrayList<>();
        this.games = new ArrayList<>();
    }

    // Add a team to the tournament
    public void addTeam(Team team) {
        teams.add(team);
    }

    // Schedule a game
    public void scheduleGame(Game game) {
        games.add(game);
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<Game> getGames() {
        return games;
    }
}

