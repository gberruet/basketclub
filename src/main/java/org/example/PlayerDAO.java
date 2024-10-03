package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAO {
    public static void createPlayerDB(Player player){
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()){
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO players (name, jerseyNumber) VALUES (?, ?)";
                ps = cnx.prepareStatement(query);
                ps.setString(1, player.getName());
                ps.setInt(2, player.getJerseyNumber());
                ps.executeUpdate();
                System.out.println("El jugador fue creado");
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void showPlayersDB(){
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM players";
                ps = cnx.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()){
                    System.out.println("ID: "+rs.getInt("id"));
                    System.out.println("Name: "+rs.getString("name"));
                    System.out.println("JerseyNumber: "+rs.getString("jerseyNumber"));
                    System.out.println("");
                }
            }catch (SQLException ex){
                System.out.println("No se pudieron recuperar los jugadores");
                System.out.println(ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void deletePlayerDB(int id){
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()) {
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM player WHERE id = ?";
                ps = cnx.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("El jugador ha sido borrado");
            }catch (SQLException ex){
                System.out.println("No se pudo borrar el jugador");
                System.out.println(ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void editPlayersDB(Player player){
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "UPDATE players SET name = ?, jerseyNumber = ? WHERE id = ?";
                ps = cnx.prepareStatement(query);
                ps.setString(1, player.getName());
                ps.setInt(2, player.getJerseyNumber());
                ps.setInt(3, player.getId());
                ps.executeUpdate();
                System.out.println("El jugador se actualizo correctamente");
            }catch (SQLException ex){
                System.out.println("No se pudo actualizar el jugador");
                System.out.println(ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
