/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author Samuel
 */
public class Enlace {
    private Connection conn;
    public void establecerConexion() { 
        System.out.println("Connection to SQLite has been established.");
        try {  
            // db parameters  
            String url = "jdbc:sqlite:db/Cliente.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection("jdbc:sqlite:db/Cliente.db");  
            // System.out.println(conn.isClosed());
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
    } 
    public Connection obtenerConexion(){
        return conn;
    }
    public synchronized void insertarCliente(Cliente m) {  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO Cliente (nombre, id, ciudad, marca, modelo, numero, pago, plan) " +
                    "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', %d, '%s')",
                    m.getNombre(),
                    m.getId(),
                    m.getCiudad(),
                    m.getMarca(),
                    m.getModelo(),
                    m.getNumero(),
                    m.getPago(),
                    m.getPlan());
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception:");
             System.out.println(e.getMessage());  
             
        }  
    }
    public synchronized ArrayList<Cliente> obtenerDataCliente() {  
        ArrayList<Cliente> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from Cliente;";
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                Cliente m = new Cliente();
                m.setNombre(rs.getString("nombre"));
                m.setId(rs.getString("id"));
                m.setCiudad(rs.getString("ciudad"));
                m.setMarca(rs.getString("marca"));
                m.setModelo(rs.getString("modelo"));
                m.setNumero(rs.getString("numero"));
                m.setPago(rs.getInt("pago"));
                m.setPlan(rs.getString("plan"));
                lista.add(m);
            }
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarCliente");
             System.out.println(e.getMessage());  
        }  
        return lista;
    }
    
}
