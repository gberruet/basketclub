package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TournamentDAO {
    public static void createTournamentDB(Tournament tournament){
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()){
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO tournaments (name) VALUES (?)";
                ps = cnx.prepareStatement(query);
                ps.setString(1, tournament.getName());
                ps.executeUpdate();
                System.out.println("El torneo fue creado");
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void showTournamentsDB(){
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM tournaments";
                ps = cnx.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()){
                    System.out.println("ID: "+rs.getInt("id"));
                    System.out.println("Name: "+rs.getString("name"));
                    System.out.println("");
                }
            }catch (SQLException ex){
                System.out.println("No se pudieron recuperar los torneos");
                System.out.println(ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void deleteTournamentDB(int id){
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()) {
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM tournaments WHERE id = ?";
                ps = cnx.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("El torneo ha sido borrado");
            }catch (SQLException ex){
                System.out.println("No se pudo borrar el torneo");
                System.out.println(ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void editTournamentsDB(Tournament tournament){
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "UPDATE tournaments SET name = ? WHERE id = ?";
                ps = cnx.prepareStatement(query);
                ps.setString(1, tournament.getName());
                ps.setInt(2, tournament.getId());
                ps.executeUpdate();
                System.out.println("El torneo se actualizo correctamente");
            }catch (SQLException ex){
                System.out.println("No se pudo actualizar el torneo");
                System.out.println(ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
