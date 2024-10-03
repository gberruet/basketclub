package org.example;

import java.util.Scanner;

public class teamService {
    public static void createTeam(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre del equipo");
        String team = sc.nextLine();

        Team registro = new Team(team);
        TeamDAO.createTeamDB(registro);
    }

    public static void showTeams(){
        TeamDAO.showTeamsDB();
    }

    public static void deleteTeam(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del equipo a borrar");
        int id = sc.nextInt();
        TeamDAO.deleteTeamDB(id);
    }

    public static void editTeam(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo equipo");
        String name = sc.nextLine();

        System.out.println("Indica el ID del equipo a editar");
        int id = sc.nextInt();

        Team actualizacion = new Team(name);
        actualizacion.setId(id);
        actualizacion.setName(name);
        TeamDAO.editTeamsDB(actualizacion);
    }
}
