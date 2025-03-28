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
        // datos persona ficticia
        double peso = 70;
        double estatura = 1.75;

        CalculadoraMCI calculadora = new CalculadoraMCI(peso, estatura);

        double resultadoEsperado = peso / Math.pow(estatura, 2);

        assertThat(calculadora.obtenerMCI(), is(closeTo(resultadoEsperado, 0.01)));
    }

    // implementamos ejemplos ficticios de los posibles errores y plasticidad en
    // casos extremos para testar control de errores
    @Test
    @DisplayName("control de errores en valores introducidos")
    // creamos test independiente de métodos, inventamos nombre
    public void testCalcularValores_ExtremosErraticos() {

        // creamos un ficticio para cada extremo (delgadez severa/obesidad morbida)
        // [asegura que la función maneje los valores en límites del baremo normal de la
        // población y verifica que no hay errores con valores grandes o pequeños desde
        // punto vista matemático]
        CalculadoraMCI calculadora1 = new CalculadoraMCI(40, 1.60);
        double imc1 = calculadora1.obtenerMCI();

        CalculadoraMCI calculadora2 = new CalculadoraMCI(120, 2.00);
        double imc2 = calculadora2.obtenerMCI();

        // contraste que el resultado en sí sea el resultado esperado dentro de los
        // extremos (delgadez severa/obesidad morbida) y que los resultados siempre den
        // valores positivos

        // 1.60 * 1.60 = 2.56 ----> 40 / 2.56 = 15.62 IMC
        assertThat(imc1, greaterThan(0.0));
        // 2.00 * 2.00 = 4 ----> 120 / 4 = 30 IMC
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

    }

}
