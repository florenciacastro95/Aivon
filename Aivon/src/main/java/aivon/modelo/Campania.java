package aivon.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/*Campaña vigente: periodo de tiempo de venta.
 * Hay 14 campañas anuales (25 dias). Cada Pedido pertenece a una Campania relacion de asociación .*/
public class Campania {

    //atributos -3-

    private int numero;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double monto;
    private boolean activa;

    private ArrayList<Pedido> pedidos;

    //construuu

    public Campania(int numero, LocalDate fechaInicio, LocalDate fechaFin,double monto, boolean activa) {
        this.numero = numero;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.monto = monto;
        this.activa = activa;
        this.pedidos = new ArrayList<>();
    }

    //Gestión de pedidos

    public void agregarPedido(Pedido pedido) {
        if (pedido == null) {
            return;
        }
        pedidos.add(pedido);
    }

    public void quitarPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public boolean tienePedidos() {
        return !pedidos.isEmpty();
    }

    //getters y setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}