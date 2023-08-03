/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Samuel
 */
public class PPmegas extends Plan {
    private int tarifaBase;

    public PPmegas(String nombre, String id, int megasEnGigas, int costoPorGiga, int tarifaBase) {
        super(nombre, id, 0, 0, megasEnGigas, costoPorGiga); // Los atributos compartidos se inicializan a 0 por defecto en este caso
        this.tarifaBase = tarifaBase;
    }
    
        public PPmegas() {
        super("", "", 0, 0, 0, 0); // Los atributos compartidos se inicializan a 0 por defecto en este caso
        this.tarifaBase = 0;
    }

    public int getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(int tarifaBase) {
        this.tarifaBase = tarifaBase;
    }
    
}