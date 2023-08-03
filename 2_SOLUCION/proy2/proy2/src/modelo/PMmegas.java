/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Samuel
 */
public class PMmegas extends Plan {
    public PMmegas(String nombre, String id, int minutos, int costoMinutos, int megasEnGigas, int costoPorGiga) {
        super(nombre, id, minutos, costoMinutos, megasEnGigas, costoPorGiga);
    }
    
        public PMmegas() {
        super("", "", 0, 0, 0, 0);
    }
}