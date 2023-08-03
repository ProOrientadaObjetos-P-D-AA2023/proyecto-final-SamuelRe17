/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Cliente {
    private String nombre;
    private String id;
    private String ciudad;
    private String marca;
    private String modelo;
    private String numero;
    private int pago;
    private String plan;

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNumero() {
        return numero;
    }

    public int getPago() {
        return pago;
    }

    public String getPlan() {
        return plan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
    
    
    
}
