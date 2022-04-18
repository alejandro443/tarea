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
public class ProductoDAO implements CRUDPRODUCTO{

    
     Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List listar() {
  List<Producto> lista =new ArrayList <>();
        String sql ="select * from Producto";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while (rs.next()) {                
                Producto p=new Producto();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setStock((int) rs.getDouble(4));
                p.setEstado(rs.getString(5));
               lista.add(p);

                
                
                
            }
        } catch (Exception e) {
        }
        return lista;    }

    @Override
    public int add(Object[] o) {
  int r=0;
        String sql="insert into Producto(Nombres,Precio,Stock,Estado)values(?,?,?,?)";
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
        return r;    }

    @Override
    public int actulizacion(Object[] o) {
 int r=0;
        String sql="update Producto set Nombres=?,Precio=?,Stock=?,Estado=? where IdProducto=?"; //verificar bien la comsulta que concuerden con los atributos de la bd
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
        return  r;    }

    @Override
    public void eliminar(int id) {
String sql="delete from Producto where IdProducto=?";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }    }
    
}
