package aivon.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
//muchas relaciones >-<
/*El pedido realizado por UNA Revendedora (lo modele como asoc bidireccional) dentro de UNA Campania (asoc unid).
*Se compone de una o varias Cajas (compo, las cajas no existen si el pedido no existe).*/
public class Pedido {

    //atributos uwu
    private int nro;
    private LocalDate fechaIngreso;
    private LocalDate fechaEntrega;
    private LocalDate fechaPago;
    private int cantCajas;
    private String domicilio;
    private String qr;
    private double importe;
    private boolean pago;
    private Revendedora revendedora;
    private Campania campania;
    private ArrayList<Caja> cajas;

    //constru

    public Pedido(int nro, LocalDate fechaIngreso, LocalDate fechaEntrega,
                  String domicilio, String qr, Revendedora revendedora, Campania campania) {
        this.nro = nro;
        this.fechaIngreso = fechaIngreso;
        this.fechaEntrega = fechaEntrega;
        this.fechaPago = null;
        this.domicilio = domicilio;
        this.qr = qr;
        this.revendedora = revendedora;
        this.campania = campania;
        this.cajas = new ArrayList<>();
        this.cantCajas = 0;
        this.importe = 0;
        this.pago = false;
    }

    //gestión del pedido

    //aca agrega una caja al pedido y calcula cantidad de cajas e importe.
    public void agregarCaja(Caja caja) {
        if (caja == null) {
            return;
        }

        this.cajas.add(caja);
        this.cantCajas = this.cajas.size();
        this.importe = calcularImporte();
    }

    //Calcula el importe total del pedido a partir de sus cajas.
    public double calcularImporte() {
        double total = 0.0;
        for (Caja caja : cajas) {
            total += caja.calcularTotal();
        }
        return total;
    }

    //marca el pedido como pagado en la fecha indicada.
    public void registrarPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
        this.pago = true;
    }

    //confirma si este pedido corresponde a la campaña
    public boolean hayPedido(Campania campania) {
        if (campania == null || this.campania == null) {
            return false;
        }
        return this.campania.getNumero() == campania.getNumero();
    }

    //fetters y setters

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getCantCajas() {
        return cantCajas;
    }

    public void setCantCajas(int cantCajas) {
        this.cantCajas = cantCajas;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Revendedora getRevendedora() {
        return revendedora;
    }

    public void setRevendedora(Revendedora revendedora) {
        this.revendedora = revendedora;
    }

    public Campania getCampania() {
        return campania;
    }

    public void setCampania(Campania campania) {
        this.campania = campania;
    }

    public ArrayList<Caja> getCajas() {
        return cajas;
    }

    public void setCajas(ArrayList<Caja> cajas) {
        this.cajas = cajas;
        this.cantCajas = (cajas == null) ? 0 : cajas.size();
        this.importe = (cajas == null) ? 0.0 : calcularImporte();
    }
}
