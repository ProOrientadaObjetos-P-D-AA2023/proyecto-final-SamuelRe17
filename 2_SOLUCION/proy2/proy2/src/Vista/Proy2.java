/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;


import controlador.Enlace;
import modelo.Cliente;
import controlador.Enlace2;
import modelo.PPminutos;
import modelo.PMmegase;
import controlador.Enlace3;
import controlador.Enlace4;
import controlador.Enlace5;
import java.util.Scanner;
import modelo.PPmegas;
import modelo.PMmegas;

public class Proy2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        
        int opc, pago;
        
        String nombre, id, ciudad, marca, modelo, numero, plan;
        
        System.out.println("Ingrese nombre: ");
        nombre = sc.nextLine();
        System.out.println("Ingrese cedula: ");
        id = sc.nextLine();
        System.out.println("Ingrese ciudad: ");
        ciudad = sc.nextLine();
        System.out.println("Ingrese marca: ");
        marca = sc.nextLine();
        System.out.println("Ingrese modelo: ");
        modelo = sc.nextLine();
        System.out.println("Ingrese numero: ");
        numero = sc.nextLine();
        System.out.println("Ingrese pago: ");
        pago = sc.nextInt();
        System.out.println("Ingrese plan: ");
        plan = sc.nextLine();
        
        Enlace c = new Enlace();
        Cliente m = new Cliente();
        m.setNombre(nombre);
        m.setId(id);
        m.setCiudad(ciudad);
        m.setMarca(marca);
        m.setModelo(modelo);
        m.setNumero(numero);
        m.setPago(pago);
        m.setPlan(plan);
        
        c.insertarCliente(m);
        for (int i = 0; i < c.obtenerDataCliente().size(); i++) {
            System.out.printf("%s\n", c.obtenerDataCliente().get(i));
        }
        
        do {
            
        System.out.println("====================MENÚ====================");
        System.out.println("Elija que tipo de plan movil que desea:     ");
        System.out.println("Plan Post Pago Minutos Megas Economico   [1]");
        System.out.println("Plan Post Pago Minutos                   [2]");
        System.out.println("Plan Post Pago Megas                     [3]");
        System.out.println("Plan Post Pago Minutos Megas             [4]");
        System.out.println("Salir                                    [0]");
    
        opc = sc.nextInt();
            
            switch (opc) {
                
                case 1:
                    
                    Enlace2 c2 = new Enlace2();
                    PMmegase m2 = new PMmegase();
                    m2.setNombre(nombre);
                    m2.setId(id);
                    m2.setMinutos(20);
                    m2.setCostoMinutos(0);
                    m2.setMegasEnGigas(3);
                    m2.setCostoPorGiga(6);
                    m2.setPorcentajeDescuento(10);
        
                    c2.insertarPMmegase(m2);
                    for (int i = 0; i < c2.obtenerDataPMmegase().size(); i++) {
                        System.out.printf("%s\n", c2.obtenerDataPMmegase().get(i));
                    }
                    
                    
                    System.out.println("\n========== Factura ==========");
                    System.out.println("Nombre: " + m.getNombre());
                    System.out.println("ID: " + m.getId());
                    System.out.println("Tipo de Plan: " + "Plan Post Pago Minutos Megas Económicos");

        
                    int calcularM2 = (m2.getMinutos()* m2.getCostoMinutos())+(m2.getMegasEnGigas()* m2.getCostoPorGiga());    
        
        
                    System.out.println("Costo Total del plan: $" + calcularM2);
                    System.out.println("=============================\n");
                    
                    break;
                
                case 2:
                    
                    Enlace3 c3 = new Enlace3();
                    PPminutos m3 = new PPminutos();
                    m3.setNombre(nombre);
                    m3.setId(id);
                    m3.setMinutosNacionales(20);
                    m3.setCostoMinutos(1);
                    m3.setMinutosInternacionales(30);
                    m3.setCostoMinutoInternacional(5);
        
                    c3.insertarPPminutos(m3);
                    for (int i = 0; i < c3.obtenerDataPPminutos().size(); i++) {
                        System.out.printf("%s\n", c3.obtenerDataPPminutos().get(i));
                    }
                    
                    System.out.println("\n========== Factura ==========");
                    System.out.println("Nombre: " + m.getNombre());
                    System.out.println("ID: " + m.getId());
                    System.out.println("Tipo de Plan: " + "Plan Post Pago Minutos");

        
                    int calcularM3 = (m3.getMinutosNacionales()* m3.getCostoMinutoNacional())+(m3.getMinutosInternacionales()* m3.getCostoMinutoInternacional());    
        
        
                    System.out.println("Costo Total del plan: $" + calcularM3);
                    System.out.println("=============================\n");                    
                    
                    break;
                
                case 3:
                    
                    Enlace4 c4 = new Enlace4();
                    PPmegas m4 = new PPmegas();
                    m4.setNombre(nombre);
                    m4.setId(id);
                    m4.setMegasEnGigas(8);
                    m4.setCostoPorGiga(3);
                    m4.setTarifaBase(24);
        
                    c4.insertarPPmegas(m4);
                    for (int i = 0; i < c4.obtenerDataPPmegas().size(); i++) {
                        System.out.printf("%s\n", c4.obtenerDataPPmegas().get(i));
                    }
                    
                    System.out.println("\n========== Factura ==========");
                    System.out.println("Nombre: " + m.getNombre());
                    System.out.println("ID: " + m.getId());
                    System.out.println("Tipo de Plan: " + "Plan Post Pago Megas");

        
                    int calcularM4 = ((m4.getMegasEnGigas())* m4.getCostoPorGiga());    
        
                    if (calcularM4 < m4.getTarifaBase()){
                        
                        System.out.println("No alcanza la tarifa base para adquirir el plan");
                        
                    }else{
                        
                        System.out.println("Costo Total del plan: $" + calcularM4);
                        System.out.println("=============================\n");    
                    }    
                    
                    break;
                
                case 4:
                    
                    Enlace5 c5 = new Enlace5();
                    PMmegas m5 = new PMmegas();
                    m5.setNombre(nombre);
                    m5.setId(id);
                    m5.setMinutos(30);
                    m5.setCostoMinutos(1);
                    m5.setMegasEnGigas(4);
                    m5.setCostoPorGiga(3);
        
                    c5.insertarPMmegas(m5);
                    for (int i = 0; i < c5.obtenerDataPMmegas().size(); i++) {
                        System.out.printf("%s\n", c5.obtenerDataPMmegas().get(i));
                    }
                    
                    System.out.println("\n========== Factura ==========");
                    System.out.println("Nombre: " + m.getNombre());
                    System.out.println("ID: " + m.getId());
                    System.out.println("Tipo de Plan: " + "Plan Post Pago Minutos Megas");

        
                    int calcularM5 = (m5.getMinutos()* m5.getCostoMinutos())+(m5.getMegasEnGigas() * m5.getCostoPorGiga());    
        
        
                    System.out.println("Costo Total del plan: $" + calcularM5);
                    System.out.println("=============================\n");                    
                    
                    break;
                    
                case 0:
                    
                    System.out.println("Saliendo.......");

                    break;
                    
                default:
                    
                    System.out.println("Opcion invalida");
                    
                    break;
            }
        } while (opc != 0);

        sc.close();
        
    }
        
}


    

