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
import modelo.PPminutos;

/**
 *
 * @author Samuel
 */
public class Enlace3 {
private Connection conn;
    public void establecerConexion() { 
        System.out.println("Connection to SQLite has been established.");
        try {  
            // db parameters  
            String url = "jdbc:sqlite:db/PPminutos.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection("jdbc:sqlite:db/PPminutos.db");  
            // System.out.println(conn.isClosed());
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
    } 
    public Connection obtenerConexion(){
        return conn;
    }
    public synchronized void insertarPPminutos(PPminutos m) {  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO PPminutos (nombre, id, minutosNacionales, costoMinutoNacional, minutosInternacionales, costoMinutoInternacional) " +
                    "VALUES ('%s', '%s', '%d', '%d', '%d', '%d')",
//                      
                    
                    m.getNombre(),
                    m.getId(),
                    m.getMinutosNacionales(),
                    m.getCostoMinutoNacional(),
                    m.getMinutosInternacionales(),
                    m.getCostoMinutoInternacional()
                    );
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception:");
             System.out.println(e.getMessage());  
             
        }  
    }
    public synchronized ArrayList<PPminutos> obtenerDataPPminutos() {  

        ArrayList<PPminutos> lista = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PPminutos;";
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                PPminutos m = new PPminutos();
                m.setNombre(rs.getString("nombre"));
                m.setId(rs.getString("id"));
                m.setMinutosNacionales(rs.getInt("minutosNacionales"));
                m.setCostoMinutoNacional(rs.getInt("costoMinutoNacional"));
                m.setMinutosInternacionales(rs.getInt("minutosInternacionales"));
                m.setCostoMinutoInternacional(rs.getInt("costoMinutoInternacional"));
                
                
                lista.add(m);
            }
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarPPminutos");
             System.out.println(e.getMessage());  
        }  
        return lista;
    }
}
