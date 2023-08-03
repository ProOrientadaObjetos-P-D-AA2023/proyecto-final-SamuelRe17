/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Samuel
 */
public class PPminutos extends Plan {
    private int minutosNacionales;
    private int costoMinutoNacional;
    private int minutosInternacionales;
    private int costoMinutoInternacional;

    public PPminutos(String nombre, String id, int minutosNacionales, int costoMinutoNacional, int minutosInternacionales, int costoMinutoInternacional) {
        super(nombre, id, 0, 0, 0, 0); // Los atributos compartidos se inicializan a 0 por defecto en este caso
        this.minutosNacionales = minutosNacionales;
        this.costoMinutoNacional = costoMinutoNacional;
        this.minutosInternacionales = minutosInternacionales;
        this.costoMinutoInternacional = costoMinutoInternacional;
    }
    
        public PPminutos() {
        super("", "", 0, 0, 0, 0); 
        this.minutosNacionales = 0;
        this.costoMinutoNacional = 0;
        this.minutosInternacionales = 0;
        this.costoMinutoInternacional = 0;
    }

    public int getMinutosNacionales() {
        return minutosNacionales;
    }

    public int getCostoMinutoNacional() {
        return costoMinutoNacional;
    }

    public int getMinutosInternacionales() {
        return minutosInternacionales;
    }

    public int getCostoMinutoInternacional() {
        return costoMinutoInternacional;
    }

    public void setMinutosNacionales(int minutosNacionales) {
        this.minutosNacionales = minutosNacionales;
    }

    public void setCostoMinutoNacional(int costoMinutoNacional) {
        this.costoMinutoNacional = costoMinutoNacional;
    }

    public void setMinutosInternacionales(int minutosInternacionales) {
        this.minutosInternacionales = minutosInternacionales;
    }

    public void setCostoMinutoInternacional(int costoMinutoInternacional) {
        this.costoMinutoInternacional = costoMinutoInternacional;
    }
    
}