package org.example;

import java.util.Scanner;

public class tournamentService {
    public static void createTournament(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre del torneo");
        String tournament = sc.nextLine();

        Tournament registro = new Tournament(tournament);
        TournamentDAO.createTournamentDB(registro);
    }

    public static void showTournaments(){
        TournamentDAO.showTournamentsDB();
    }

    public static void deleteTournament(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del torneo a borrar");
        int id = sc.nextInt();
        TournamentDAO.deleteTournamentDB(id);
    }

    public static void editTournament(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo torneo");
        String name = sc.nextLine();

        System.out.println("Indica el ID del torneo a editar");
        int id = sc.nextInt();

        Tournament actualizacion = new Tournament(name);
        actualizacion.setId(id);
        actualizacion.setName(name);
        TournamentDAO.editTournamentsDB(actualizacion);
    }
}
