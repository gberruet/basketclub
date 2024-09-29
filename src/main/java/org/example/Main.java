package org.example;

import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        try (Connection cnx = conexion.getConnection()){

        }catch (Exception e){
            System.out.println(e);
        }

        // Create teams
        Team teamA = new Team("Villa San Carlos");
        Team teamB = new Team("Ceye");

        // Create players for each team
        teamA.addPlayer(new Player("Gabriel Cejas", 10));
        teamA.addPlayer(new Player("Pablo Marini", 15));

        teamB.addPlayer(new Player("El pepo", 9));
        teamB.addPlayer(new Player("Tony Montana", 12));

        // Create a tournament
        Tournament tournament = new Tournament("Zona A2 - Torneo Apertura 2024");
        tournament.addTeam(teamA);
        tournament.addTeam(teamB);

        // Schedule a game
        Game game = new Game(teamA, teamB);
        tournament.scheduleGame(game);

        // Set game score and determine the winner
        game.setScore(94, 90);
        System.out.println("Winner: " + game.getWinner().getName());
    }
}