package aivon.modelo;

import java.util.ArrayList;

//Vehículo usado para distribuir pedidos. relacioon de agreg con pedido

public class Vehiculo {

    //atributos

    private String patente;
    private String modelo;
    private String ubicacionGps;

    private ArrayList<Pedido> pedidos;

    //constructor
    public Vehiculo(String patente,String modelo, String ubicacionGps) {
        this.patente = patente;
        this.modelo = modelo;
        this.ubicacionGps = ubicacionGps;
        this.pedidos = new ArrayList<>();
    }

    // gestión de pedidos

    public void cargarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    public void descargarPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }
    public String seguirVehiculo() {
        return ubicacionGps;
    }

    //getters y setters
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getUbicacionGps() {
        return ubicacionGps;
    }

    public void setUbicacionGps(String ubicacionGps) {
        this.ubicacionGps = ubicacionGps;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}