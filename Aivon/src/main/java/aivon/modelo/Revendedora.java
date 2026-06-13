package aivon.modelo;

import java.util.ArrayList;

// Compo: la revendedora gestiona su dinero en una cuenta propia.
// Asoc: una revendedora puede tener varios pedidos (uno por campaña).
public class Revendedora {
    //atributos -*-
    private String nombreCompleto;
    private String dni;
    private String telefono;
    private String domicilio;
    private Cuenta cuenta;
    private ArrayList<Pedido> pedidos;

    //constru
    public Revendedora(String nombre, String dni, String telefono, String domicilio, Cuenta cuenta) {
        this.nombreCompleto = nombre;
        this.dni = dni;
        this.telefono=telefono;
        this.domicilio=domicilio;
        this.cuenta = cuenta;
        this.pedidos = new ArrayList<>();
    }

    // dlegacion hacia la cuenta (la revendedora gestiona su dinero)

    public void retirarDinero(double monto) throws Exception {
        cuenta.retirarDinero(monto);
    }

    public void depositarDinero(double monto) {
        cuenta.depositarDinero(monto);
    }

    public void transferirDinero(Revendedora destino, double monto) throws Exception {
        cuenta.transferirDinero(destino, monto);
    }

    public double convertirMoneda(String valor) {
        return cuenta.convertirMoneda(valor);
    }

    public void pagoDemorado(long milisegundos) throws InterruptedException {
        cuenta.pagoDemorado(milisegundos);
    }

    //Gestion de pedido

    /* Agrega un pedido. La revendedora hace como maximo UN pedido por campaña y
     * si ya existe un pedido para esa campaña, no se agrega y devuelve false.*/
    public boolean agregarPedido(Pedido pedido) {
        if (hayPedido(pedido.getCampania())) {
            return false;
        }
        this.pedidos.add(pedido);
        return true;
    }

    //Indica si la revendedora ya tiene un pedido para la campaña.
    public boolean hayPedido(Campania campania) {
        for (Pedido p : pedidos) {
            if (p.getCampania().getNumero() == campania.getNumero()) {
                return true;
            }
        }
        return false;
    }

    //Lista por consola los pedidos que ha hecho la revendedora.
    public void listarPedidos() {
        System.out.println("Pedidos de la revendedora " + nombreCompleto + ":");
        if (pedidos.isEmpty()) {
            System.out.println("  (sin pedidos)");
        }
        for (Pedido p : pedidos) {
            System.out.println("  - Pedido #" + p.getNro()
                    + " | Campania " + p.getCampania().getNumero()
                    + " | Importe $" + p.getImporte());
        }
    }

    // getterr y setters ----

    public String getNombre() {
        return nombreCompleto;
    }

    public void setNombre(String nombre) {
        this.nombreCompleto = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}