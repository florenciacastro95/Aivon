package aivon.modelo;
/* Cuenta de dinero de una Revendedora creada para realizar taras como:
 * retirar, depositar, transferir, convertir moneda y simular un pago demorado.
 * La Revendedora gestiona su dinero a traves de esta cuenta (composicion).*/
public class Cuenta {

    //atributos -3-

    private double saldo;
    private String moneda;

    //constru

    public Cuenta() {
        this.saldo = 0.0;
        this.moneda = null;
    }

    public Cuenta(double saldo) {
        this.saldo = saldo;
        this.moneda = null;
    }

    public Cuenta(double saldo, String moneda) {
        this.saldo = saldo;
        this.moneda = moneda;
    }

    //Gestión de dinero

    public void retirarDinero(double monto) throws Exception {
        if (monto > saldo) {throw new Exception("Su cuenta no tiene saldo.");}
        saldo -= monto;
    }

    public void depositarDinero(double monto) {
        saldo += monto;
    }

    public void transferirDinero(Revendedora destino, double monto) throws Exception {
        this.retirarDinero(monto);
        destino.getCuenta().depositarDinero(monto);
    }

    /*Acá se convierte un string de moneda a un valor double (Dolar MEP).
     * Devuelve -1 si el texto no es un num válido (ej: "1300 U$S").*/
    public double convertirMoneda(String valor) {
        try {
            return Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    //ca simula un pago que demora cierto tiempo en milisegundos. si se interrumpe el hilo tira una inteerruptedException*/
    public void pagoDemorado(long milisegundos) throws InterruptedException {
        Thread.sleep(milisegundos);
    }

    //getterssetters

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}
