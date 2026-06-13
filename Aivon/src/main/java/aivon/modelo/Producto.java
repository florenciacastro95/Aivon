package aivon.modelo;

public class Producto {

    //atributo

    private String codigo;
    private String nombre;
    private String uso;
    private double tamanoCm3;
    private double precioVenta;
    private double precioCosto;

    //construc

    public Producto(String codigo, String nombre, String uso, double tamanoCm3,double precioVenta,
    double precioCosto) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.uso = uso;
        this.tamanoCm3 = tamanoCm3;
        this.precioVenta = precioVenta;
        this.precioCosto = precioCosto;
    }

    //método de negocio

    public double calcularGanancia() {
        return precioVenta - precioCosto;
    }

    //getters y setter

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public double getTamanoCm3() {
        return tamanoCm3;
    }

    public void setTamanoCm3(double tamanoCm3) {
        this.tamanoCm3 = tamanoCm3;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }
}