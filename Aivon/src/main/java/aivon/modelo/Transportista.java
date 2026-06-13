package aivon.modelo;

import java.util.ArrayList;

// Un transportista es responsable de realizar entregas. Tiene asoc con vehiculo
// y una dependencia con pedido por su escanearPedido(pedido)
public class Transportista {

    //Atributos

    private int idTransportista;
    private String nombreCompleto;
    private String whatsapp;

    private ArrayList<Vehiculo> vehiculos;

    //constructor

    public Transportista(int idTransportista, String nombreCompleto,String whatsapp) {
        this.idTransportista = idTransportista;
        this.nombreCompleto = nombreCompleto;
        this.whatsapp = whatsapp;
        this.vehiculos = new ArrayList<>();
    }

    //gestión de vehículos

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }
    public void removerVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    //Escanea un pedido usando su código QR

    public void escanearPedido(Pedido pedido) {
        System.out.println("QR: " + pedido.getQr());
        System.out.println("Destino: "
                + pedido.getDomicilio());
    }

    //getters y setters

    public int getIdTransportista() {
        return idTransportista;
    }

    public void setIdTransportista(int idTransportista) {
        this.idTransportista = idTransportista;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}