package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection getConnection(){
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/basket_java", "root", "");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conexion;
    }
}
