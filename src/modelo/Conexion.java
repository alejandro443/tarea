/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SERGESAN PCS2021
 */
public class Conexion {
    Connection con;
    String url="jdbc:mysql://localhost:3306/bd_venta";
    String user="root";
    String pass="root";
    public Connection Conectar(){
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");   
            con=DriverManager.getConnection(url, user, pass);
            System.err.println("conectado");
        } catch (Exception e) {
            System.err.println("error");
        }
        return con;
        
    }
    
}
