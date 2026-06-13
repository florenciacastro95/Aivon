package aivon.test;
import aivon.modelo.Cuenta;
import aivon.modelo.Revendedora;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterRevendedoraTest {

    private final double montoActual;
    private final Revendedora cRev;
    private final double montoEsperado;

    public ParameterRevendedoraTest(double montoActual, Revendedora cRev, double montoEsperado) {
        this.montoActual = montoActual;
        this.cRev = cRev;
        this.montoEsperado = montoEsperado;
    }

    @Parameters(name = "{index}: retirar {0} -> esperado {2}")
    public static Collection<Object[]> tomarDatos() {
        return Arrays.asList(new Object[][]{
                {300.5, new Revendedora("Cliente Rev 1", "30000001", "2665123456", "Orale 500", new Cuenta(8699.5)), 3333.0},
                {500.0,  new Revendedora("Cliente Rev 2", "30000002", "2665123457", "Orale 501", new Cuenta(8699.5)), 8199.5},
                {9999.0, new Revendedora("Cliente Rev 3", "30000003", "2665123458", "Orale 502", new Cuenta(8699.5)), 1111.0}
        });
    }

    @Test
    public void testRetirarDinero() throws Exception {
        cRev.retirarDinero(montoActual);
        assertEquals(montoEsperado, cRev.getCuenta().getSaldo(), 0.2);
}}
