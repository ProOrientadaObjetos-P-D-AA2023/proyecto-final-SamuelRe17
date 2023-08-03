/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Samuel
 */
public class Plan {
    protected String nombre;
    protected String id;
    protected int minutos;
    protected int costoMinutos;
    protected int megasEnGigas;
    protected int costoPorGiga;
    
    public Plan(String nombre, String id, int minutos, int costoMinutos, int megasEnGigas, int costoPorGiga) {
        this.nombre = nombre;
        this.id = id;
        this.minutos = minutos;
        this.costoMinutos = costoMinutos;
        this.megasEnGigas = megasEnGigas;
        this.costoPorGiga = costoPorGiga;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setCostoMinutos(int costoMinutos) {
        this.costoMinutos = costoMinutos;
    }

    public void setMegasEnGigas(int megasEnGigas) {
        this.megasEnGigas = megasEnGigas;
    }

    public void setCostoPorGiga(int costoPorGiga) {
        this.costoPorGiga = costoPorGiga;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getCostoMinutos() {
        return costoMinutos;
    }

    public int getMegasEnGigas() {
        return megasEnGigas;
    }

    public int getCostoPorGiga() {
        return costoPorGiga;
    }
    
    
}
