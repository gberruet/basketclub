package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("::::::::::::::::::::::::");
            System.out.println(" BasketClub");
            System.out.println(" 1. TORNEOS");
            System.out.println(" 2. EQUIPOS");
            System.out.println(" 3. JUGADORES");
            System.out.println(" 4. SALIR");
            //leemos la opción del usuario
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    int torneo = 0;
                    do{
                        System.out.println("::::::::::::::::::::::::");
                        System.out.println(" TORNEOS");
                        System.out.println(" 1. Crear torneo");
                        System.out.println(" 2. Listar torneos");
                        System.out.println(" 3. Eliminar torneos");
                        System.out.println(" 4. Editar torneo");
                        System.out.println(" 5. Salir");
                        torneo = sc.nextInt();

                        switch (torneo){
                            case 1:
                                tournamentService.createTournament();
                                break;
                            case 2:
                                tournamentService.showTournaments();
                                break;
                            case 3:
                                tournamentService.deleteTournament();
                                break;
                            case 4:
                                tournamentService.editTournament();
                                break;
                            default:
                                break;
                        }
                    }while (torneo != 5);
                case 2:
                    int equipo = 0;
                    do{
                        System.out.println("::::::::::::::::::::::::");
                        System.out.println(" EQUIPOS");
                        System.out.println(" 1. Crear equipo");
                        System.out.println(" 2. Listar equipos");
                        System.out.println(" 3. Eliminar equipos");
                        System.out.println(" 4. Editar equipo");
                        System.out.println(" 5. Salir");
                        equipo = sc.nextInt();

                        switch (equipo){
                            case 1:
                                teamService.createTeam();
                                break;
                            case 2:
                                teamService.showTeams();
                                break;
                            case 3:
                                teamService.deleteTeam();
                                break;
                            case 4:
                                teamService.editTeam();
                                break;
                            default:
                                break;
                        }
                    }while (equipo != 5);
                case 3:
                    int jugador = 0;
                    do{
                        System.out.println("::::::::::::::::::::::::");
                        System.out.println(" JUGADORES");
                        System.out.println(" 1. Crear jugador");
                        System.out.println(" 2. Listar jugadores");
                        System.out.println(" 3. Eliminar jugadores");
                        System.out.println(" 4. Editar jugador");
                        System.out.println(" 5. Salir");
                        jugador = sc.nextInt();

                        switch (jugador){
                            case 1:
                                playerService.createPlayer();
                                break;
                            case 2:
                                playerService.showPlayers();
                                break;
                            case 3:
                                playerService.deletePlayer();
                                break;
                            case 4:
                                playerService.editPlayer();
                                break;
                            default:
                                break;
                        }
                    }while (jugador != 5);
            }
        }while (opcion != 4);
    }
}