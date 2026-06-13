package aivon.modelo;

//Cada detalle muestra un producto, la cantidad  y el subtotal.
public class DetalleCaja {

    //atributos -3-

    private Producto producto;
    private int cantidad;
    private double subtotal;

    //constru

    public DetalleCaja(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = producto.getPrecioVenta() * cantidad;
    }

    //getters setters

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        this.subtotal = producto.getPrecioVenta() * this.cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.subtotal = this.producto.getPrecioVenta() * cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}