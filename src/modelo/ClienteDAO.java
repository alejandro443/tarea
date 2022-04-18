/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SERGESAN PCS2021
 */
public class ClienteDAO implements CRUD{
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        List<Cliente> lista =new ArrayList <>();
        String sql ="select * from cliente";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {                
                Cliente c=new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEstado(rs.getString(5));
                lista.add(c);
                
                
                
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r=0;
        String sql="insert into cliente(Dni,Nombre,Direccion,Estado)values(?,?,?,?)";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setObject(1, o[0]);
             ps.setObject(2, o[1]);
             ps.setObject(3, o[2]);
             ps.setObject(4, o[3]);
            
            
            r=ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int actulizacion(Object[] o) {
        int r=0;
        String sql="update cliente set Dni=?,Nombre=?,Direccion=?,Estado=? where IdCliente=?"; //verificar bien la comsulta que concuerden con los atributos de la bd
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
         ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
           ps.setObject(3, o[2]);
          ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
           r= ps.executeUpdate();
           
        } catch (Exception e) {
            System.err.println("no actualiza");
        }
        return  r;
    }

    @Override
    public void eliminar(int id) {
        String sql="delete from cliente where IdCliente=?";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
}
