package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamDAO {
    public static void createTeamDB(Team team){
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()){
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO teams (name) VALUES (?)";
                ps = cnx.prepareStatement(query);
                ps.setString(1, team.getName());
                ps.executeUpdate();
                System.out.println("El equipo fue creado");
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void showTeamsDB(){
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM teams";
                ps = cnx.prepareStatement(query);
                rs = ps.executeQuery();

                while (rs.next()){
                    System.out.println("ID: "+rs.getInt("id"));
                    System.out.println("Name: "+rs.getString("name"));
                    System.out.println("");
                }
            }catch (SQLException ex){
                System.out.println("No se pudieron recuperar los equipos");
                System.out.println(ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void deleteTeamDB(int id){
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()) {
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM team WHERE id = ?";
                ps = cnx.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("El equipo ha sido borrado");
            }catch (SQLException ex){
                System.out.println("No se pudo borrar el equipo");
                System.out.println(ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void editTeamsDB(Team team){
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.getConnection()) {
            PreparedStatement ps = null;

            try {
                String query = "UPDATE teams SET name = ? WHERE id = ?";
                ps = cnx.prepareStatement(query);
                ps.setString(1, team.getName());
                ps.setInt(2, team.getId());
                ps.executeUpdate();
                System.out.println("El equipo se actualizo correctamente");
            }catch (SQLException ex){
                System.out.println("No se pudo actualizar el equipo");
                System.out.println(ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
