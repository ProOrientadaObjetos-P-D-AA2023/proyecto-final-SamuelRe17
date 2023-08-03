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
import modelo.PMmegas;

/**
 *
 * @author Samuel
 */
public class Enlace5 {
private Connection conn;
    public void establecerConexion() { 
        System.out.println("Connection to SQLite has been established.");
        try {  
            // db parameters  
            String url = "jdbc:sqlite:db/PMmegas.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection("jdbc:sqlite:db/PMmegas.db");  
            // System.out.println(conn.isClosed());
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
    } 
    public Connection obtenerConexion(){
        return conn;
    }
    public synchronized void insertarPMmegas(PMmegas m) {  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO PMmegas (nombre, id, minutos, costoMinutos, megasEnGigas, costoPorGiga) " +
                    "VALUES ('%s', '%s', '%d', '%d', '%d', '%d')",
//                      
                    
                    m.getNombre(),
                    m.getId(),
                    m.getMinutos(),
                    m.getCostoMinutos(),
                    m.getMegasEnGigas(),
                    m.getCostoPorGiga()
                    
                    );
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception:");
             System.out.println(e.getMessage());  
             
        }  
    }
    public synchronized ArrayList<PMmegas> obtenerDataPMmegas() {  

        ArrayList<PMmegas> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PMmegas;";
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                PMmegas m = new PMmegas();
                m.setNombre(rs.getString("nombre"));
                m.setId(rs.getString("id"));
                m.setMinutos(rs.getInt("minutos"));
                m.setCostoMinutos(rs.getInt("costoMinutos"));
                m.setMegasEnGigas(rs.getInt("megasEnGigas"));
                m.setCostoPorGiga(rs.getInt("costoPorGiga"));
                
                
                
                lista.add(m);
            }
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarPMmegas");
             System.out.println(e.getMessage());  
        }  
        return lista;
    }
}

