package aivon.modelo;

import java.util.ArrayList;

/*Caja de pedido. Tengo en cuenta que cada caja se detalla por varios DetalleCaja (compo, no hay detalle sin caja).
 * Un Pedido se compone de una o varias Cajas, no hay caja sin pedido.*/
public class Caja {

    //atributos -3-

    private int numero;
    private ArrayList<DetalleCaja> detalles;

    //construuu

    public Caja(int numero) {
        this.numero = numero;
        this.detalles = new ArrayList<>();
    }

    //Gestión de detalles

    public void agregarDetalle(DetalleCaja detalle) {
        if (detalle == null) {
            return;
        }
        detalles.add(detalle);
    }

    public void quitarDetalle(DetalleCaja detalle) {
        detalles.remove(detalle);
    }

    public double calcularTotal() {
        double total = 0;
        for (DetalleCaja detalle : detalles) {
            total += detalle.getSubtotal();
        }
        return total;
    }

    // getters y setters

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public ArrayList<DetalleCaja> getDetalles() {
        return detalles;
    }
    public void setDetalles(ArrayList<DetalleCaja> detalles) {
        this.detalles = detalles;
    }
}