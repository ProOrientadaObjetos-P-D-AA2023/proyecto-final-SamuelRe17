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
import modelo.PPmegas;

/**
 *
 * @author Samuel
 */
public class Enlace4 {
private Connection conn;
    public void establecerConexion() { 
        System.out.println("Connection to SQLite has been established.");
        try {  
            // db parameters  
            String url = "jdbc:sqlite:db/PPmegas.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection("jdbc:sqlite:db/PPmegas.db");  
            // System.out.println(conn.isClosed());
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
    } 
    public Connection obtenerConexion(){
        return conn;
    }
    public synchronized void insertarPPmegas(PPmegas m) {  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO PPmegas (nombre, id, megasEnGigas, costoPorGiga, tarifaBase) " +
                    "VALUES ('%s', '%s', '%d', '%d', '%d')",
//                      
                    
                    m.getNombre(),
                    m.getId(),
                    m.getMegasEnGigas(),
                    m.getCostoPorGiga(),
                    m.getTarifaBase()
                    
                    );
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception:");
             System.out.println(e.getMessage());  
             
        }  
    }
    public synchronized ArrayList<PPmegas> obtenerDataPPmegas() {  

        ArrayList<PPmegas> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PPmegas;";
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                PPmegas m = new PPmegas();
                m.setNombre(rs.getString("nombre"));
                m.setId(rs.getString("id"));
                m.setMegasEnGigas(rs.getInt("megasEnGigas"));
                m.setCostoPorGiga(rs.getInt("costoPorGiga"));
                m.setTarifaBase(rs.getInt("tarifaBase"));
                
                
                
                lista.add(m);
            }
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarPPmegas");
             System.out.println(e.getMessage());  
        }  
        return lista;
    }
}
