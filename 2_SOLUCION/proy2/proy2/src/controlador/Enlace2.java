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
import modelo.PMmegase;

/**
 *
 * @author Samuel
 */
public class Enlace2 {
    private Connection conn;
    public void establecerConexion() { 
        System.out.println("Connection to SQLite has been established.");
        try {  
            // db parameters  
            String url = "jdbc:sqlite:db/PMmegase.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection("jdbc:sqlite:db/PMmegase.db");  
            // System.out.println(conn.isClosed());
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
    } 
    public Connection obtenerConexion(){
        return conn;
    }
    public synchronized void insertarPMmegase(PMmegase m) {  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO PMmegase (nombre, id, minutos, costoMinutos, megasEnGigas, costoPorGiga, porcentajeDescuento) " +
                    "VALUES ('%s', '%s', '%d', '%d', '%d', '%d', %d)",
//                      
                    
                    m.getNombre(),
                    m.getId(),
                    m.getMinutos(),
                    m.getCostoMinutos(),
                    m.getMegasEnGigas(),
                    m.getCostoPorGiga(),
                    m.getPorcentajeDescuento()
                    );
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception:");
             System.out.println(e.getMessage());  
             
        }  
    }
    public synchronized ArrayList<PMmegase> obtenerDataPMmegase() {  

        ArrayList<PMmegase> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PMmegase;";
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                PMmegase m = new PMmegase();
                m.setNombre(rs.getString("nombre"));
                m.setId(rs.getString("id"));
                m.setMinutos(rs.getInt("minutos"));
                m.setCostoMinutos(rs.getInt("costoMinutos"));
                m.setMegasEnGigas(rs.getInt("megasEnGigas"));
                m.setCostoPorGiga(rs.getInt("costoPorGiga"));
                m.setPorcentajeDescuento(rs.getInt("porcentajeDescuento"));
                
                lista.add(m);
            }
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarPMmegase");
             System.out.println(e.getMessage());  
        }  
        return lista;
    }
}
