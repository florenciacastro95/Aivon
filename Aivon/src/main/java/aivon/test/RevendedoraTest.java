package aivon.test;
import aivon.modelo.Cuenta;
import aivon.modelo.Revendedora;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;
public class RevendedoraTest

{
    // Variable estatica que cuenta las transacciones (usada en @After).
    private static int i = 0;
    private static LocalDate fechaLocal;
    private Revendedora revCuenta;
    private Revendedora rev3;

    @BeforeClass
    public static void beforeClass() {
        fechaLocal = LocalDate.of(2024, Month.JUNE, 8);
        System.out.println("Fecha de transaccion (LocalDate.now): " + LocalDate.now());
        System.out.println("fechaLocal de la transaccion: " + fechaLocal);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("FIN de la transaccion");
    }

    @Before
    public void before() {
        revCuenta = new Revendedora("Laura Gomez", "30111222", "2665123456", "Orale 123", new Cuenta(9000.0));
        rev3 = new Revendedora("Ana Perez", "28555444", "2665123457", "Orale 125", new Cuenta(0.0));
    }

    @After
    public void after() {
        i++;
        System.out.println("Transaccion " + i + " > El monto en cuenta es "
                + revCuenta.getCuenta().getSaldo());
    }

    // B) Intenta retirar 88000 de una cuenta de 9000 -> arroja Exception. EXITO.
    @Test(expected = Exception.class)
    public void testRetirarFallo() throws Exception {
        revCuenta.retirarDinero(88000.0);
    }

    // C) Retira un monto valido -> descuenta saldo con normalidad. EXITO.
    @Test
    public void testRetirarExito() throws Exception {
        revCuenta.retirarDinero(1000.0);
        assertEquals(8000.0, revCuenta.getCuenta().getSaldo(), 0.2);
    }

    // D) Deposita 2000 sobre 9000 -> saldo 11000. EXITO.
    @Test
    public void testDepositarDinero() {
        assertNotNull(revCuenta.getCuenta());
        revCuenta.depositarDinero(2000.0);
        assertEquals(11000.0, revCuenta.getCuenta().getSaldo(), 0.2);
    }

    // E) Transfiere 1000 a rev2 (saldo 5000) -> rev2 queda en 6000. EXITO.
    @Test
    public void testTransferirCuentaNoNula() throws Exception {
        Revendedora rev2 = new Revendedora("Marta Ruiz", "30111223", "2665123457", "Orale 124",new Cuenta(5000.0));
        assertNotNull(revCuenta.getCuenta());
        assertNotNull(rev2.getCuenta());
        revCuenta.transferirDinero(rev2, 1000.0);
        assertEquals(6000.0, rev2.getCuenta().getSaldo(), 0.2);
    }

    // F) Prueba que siempre falla con un mensaje. FALLA.
    @Test
    public void testSiempreFalla() {
        fail("Esta prueba debe fallar siempre (mensaje de fallo).");
    }

    // G) convertirMoneda("1300") -> 1300.0. EXITO.
    @Test
    public void testDolarMEP1() {
        assertEquals(1300.0, revCuenta.convertirMoneda("1300"), 0.2);
    }

    // H) convertirMoneda("1300 U$S") -> devuelve -1 (no parsea). assertEquals con 1300 FALLA.
    @Test
    public void testDolarMEP2() {
        assertEquals(1300.0, revCuenta.convertirMoneda("1300 U$S"), 0.2);
    }

    // I) assertSame entre revCuenta y rev3 (instancias distintas). FALLA.
    @Test
    public void testMismaRevendedora() {
        assertSame("Las cuentas son diferentes", revCuenta, rev3);
    }

    // J) timeout de 60 ms; pagoDemorado duerme 100 ms -> TEST TIMED. ERROR.
    @Test(timeout = 60)
    public void testPagoDemorado() throws InterruptedException {
        revCuenta.pagoDemorado(100);
    }

}
