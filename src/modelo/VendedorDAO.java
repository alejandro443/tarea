/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author SERGESAN PCS2021
 */
public class VendedorDAO {
    PreparedStatement ps;
    ResultSet rs;
   
    Conexion con=new Conexion();
    Connection acceso;
    
    public EntidadVendedor ValidarVendedor(String dni,String user){
       EntidadVendedor ev =new EntidadVendedor();  
    String sql="select * from vendedor where Dni=? and User=?";
        try {
            acceso=con.Conectar();
            ps=acceso.prepareStatement(sql);
            ps.setString(1, dni);
             ps.setString(2, user);
             rs=ps.executeQuery();
             while (rs.next()) {                
                 ev.setId(rs.getInt(1));
                 ev.setDni(rs.getString(2));
                 ev.setNom(rs.getString(3));
                 ev.setTel(rs.getString(4));
                 ev.setEstado(rs.getString(5));
                 ev.setUser(rs.getString(6));
                 System.out.println("entro");
                
            }
        } catch (Exception e) {
            System.err.println("error");
        }
        return ev;
    }
    
}
