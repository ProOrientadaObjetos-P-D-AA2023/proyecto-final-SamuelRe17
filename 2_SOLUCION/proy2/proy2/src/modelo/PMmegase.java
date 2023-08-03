/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Samuel
 */
public class PMmegase extends Plan {
        private int porcentajeDescuento;

    public PMmegase(String nombre, String id, int minutos, int costoMinutos, int megasEnGigas, int costoPorGiga, int porcentajeDescuento) {
        super(nombre, id, minutos, costoMinutos, megasEnGigas, costoPorGiga);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    // Constructor sin argumentos
    public PMmegase() {
        super("", "", 0, 0, 0, 0); 
        this.porcentajeDescuento = 0; 
    }


    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
}