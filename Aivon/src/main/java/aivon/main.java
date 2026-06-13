package aivon;
import aivon.modelo.*;
import java.time.LocalDate;
import java.time.Month;

public class main {

    public static void main(String[] args) {

        System.out.println("AIVON \n");

        //6
        Campania campania6 = new Campania(
                6,
                LocalDate.of(2026, Month.JUNE, 1),
                LocalDate.of(2026, Month.JUNE, 25),
                500000.0,
                true);

        //revendedora
        Cuenta cuentaLaura = new Cuenta(9000.0);
        Revendedora laura = new Revendedora( "Laura Gomez", "30111222", "2665123456", "Orale 123", cuentaLaura);

        //buscar 3 productos
        Producto p1 = new Producto("E001", "Esmalte Rojo", "Unas", 15, 800.0, 400.0);
        Producto p2 = new Producto("L002", "Labial Mate", "Labios", 5, 1200.0, 600.0);
        Producto p3 = new Producto("C003", "Crema Corporal", "Cuerpo", 250, 2500.0, 1300.0);

        //armar un pedido para la campaña 6
        Pedido pedido = new Pedido(
                101,
                LocalDate.of(2026, Month.JUNE, 5),
                LocalDate.of(2026, Month.JUNE, 12),
                "Av. Luna 742",
                "QR-AIVON-101",
                laura,
                campania6);

        //cja con renglones (producto + cantidad + subtotal)
        Caja caja1 = new Caja(1);
        caja1.agregarDetalle(new DetalleCaja(p1, 20)); // 20 * 800  = 16000
        caja1.agregarDetalle(new DetalleCaja(p2, 5));  //  5 * 1200 = 6000
        caja1.agregarDetalle(new DetalleCaja(p3, 2));  //  2 * 2500 = 5000

        pedido.agregarCaja(caja1);
        laura.agregarPedido(pedido);

        System.out.println("A) Pedido armado: Pedido #" + pedido.getNro()
                + " | Campania " + pedido.getCampania().getNumero()
                + " | Cajas: " + pedido.getCantCajas()
                + " | Importe $" + pedido.getImporte());
        for (DetalleCaja r : caja1.getDetalles()) {
            System.out.println("   " + r.getProducto().getNombre() + ", "
                    + r.getCantidad() + " unidades, $" + r.getSubtotal());
        }
        System.out.println();

        // hayPedido + listar
        System.out.println("Hay pedido en campaña 6? " + laura.hayPedido(campania6));
        laura.listarPedidos();
        System.out.println();

        // vehiculo que transporta el pedido
        Vehiculo vehiculo = new Vehiculo("AB123CD", "Renault Kangoo", "Deposito Central");
        vehiculo.cargarPedido(pedido);
        vehiculo.setUbicacionGps("Av. Mitre 1200");
        System.out.println("[GPS] Vehiculo " + vehiculo.getModelo() + " patente "
                + vehiculo.getPatente() + " | Ubicacion: " + vehiculo.seguirVehiculo()
                + " | Pedidos a bordo: " + vehiculo.getPedidos().size());
        System.out.println();

        //transportista escanea el QR y muestra destino
        Transportista transportista = new Transportista(1,"Carlos Diaz", "+5492664000000");
        transportista.escanearPedido(pedido);
        System.out.println();

        // ----- Gestion de dinero entre revendedoras -----
        System.out.println("Gestion de dinero");
        Cuenta cuentaMarta = new Cuenta(5000.0);
        Revendedora marta = new Revendedora("Marta Ruiz", "30111223", "2665123457", "Orale 124", cuentaMarta);
        try {
            System.out.println("Saldo Laura antes: $" + laura.getCuenta().getSaldo());
            marta.transferirDinero(laura, 1000.0);
            System.out.println("Transferencia de $1000 a Marta OK.");
            System.out.println("Saldo Laura despues: $" + laura.getCuenta().getSaldo());
            System.out.println("Saldo Marta despues: $" + marta.getCuenta().getSaldo());
        } catch (Exception e) {
            System.out.println("Error en transferencia: " + e.getMessage());
        }

        System.out.println("\n fin");
    }
}
