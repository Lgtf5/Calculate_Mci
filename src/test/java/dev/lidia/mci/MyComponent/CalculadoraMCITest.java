package dev.lidia.mci.MyComponent;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraMCITest {

    @Test
    @DisplayName("testar que el resultado de la fórmula no de negativos y que devuelva el resultado de la fórmula IMC")
    public void testCalcularMCIValoresNormales() {
       
        double peso = 70;
        double estatura = 1.75;

        CalculadoraMCI calculadora = new CalculadoraMCI(peso, estatura);

        double resultadoEsperado = peso / Math.pow(estatura, 2);

        assertThat(calculadora.obtenerMCI(), is(closeTo(resultadoEsperado, 0.01)));
    }

    @Test
    @DisplayName("control de errores en valores introducidos")

    public void testCalcularValores_ExtremosErraticos() {


        CalculadoraMCI calculadora1 = new CalculadoraMCI(40, 1.60);
        double imc1 = calculadora1.obtenerMCI();

        CalculadoraMCI calculadora2 = new CalculadoraMCI(120, 2.00);
        double imc2 = calculadora2.obtenerMCI();


        assertThat(imc1, greaterThan(0.0));
      
        assertThat(imc2, greaterThan(0.0));

    }

    @Test
    public void testCalcularMCI_PesoNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new CalculadoraMCI(-40, 1.75));
        assertEquals ("El peso y la altura no pueden ser valores negativos, deben ser mayores que cero", exception.getMessage());
    }

    @Test
    @DisplayName ("categorizar correctamente el IMC PESO_BAJO")
    public void resultadosPorCategoria() {
        
        CalculadoraMCI mciPorDebajo = new CalculadoraMCI(40, 1.60);
        assertEquals ("PESO BAJO", mciPorDebajo.obtenerCategoria());

        CalculadoraMCI normal = new CalculadoraMCI(65, 1.70);
        assertEquals("NORMAL", normal.obtenerCategoria());

        CalculadoraMCI sobrepeso = new CalculadoraMCI(80, 1.70);
        assertEquals("SOBREPESO", sobrepeso.obtenerCategoria());

    }

}
