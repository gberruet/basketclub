package org.example;

import java.util.Scanner;

public class playerService {
    public static void createPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre del jugador");
        String name = sc.nextLine();

        System.out.println("Ingresa el numero de camiseta");
        int jerseyNumber = sc.nextInt();

        Player registro = new Player(name, jerseyNumber);
        PlayerDAO.createPlayerDB(registro);
    }

    public static void showPlayers(){
        PlayerDAO.showPlayersDB();
    }

    public static void deletePlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del jugador a borrar");
        int id = sc.nextInt();
        PlayerDAO.deletePlayerDB(id);
    }

    public static void editPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo nombre");
        String name = sc.nextLine();

        System.out.println("Ingresa el numero de camiseta");
        int jerseyNumber = sc.nextInt();

        System.out.println("Indica el ID del jugador a editar");
        int id = sc.nextInt();

        Player actualizacion = new Player(name, jerseyNumber);
        actualizacion.setId(id);
        actualizacion.setName(name);
        actualizacion.setJerseyNumber(jerseyNumber);
        PlayerDAO.editPlayersDB(actualizacion);
    }
}
