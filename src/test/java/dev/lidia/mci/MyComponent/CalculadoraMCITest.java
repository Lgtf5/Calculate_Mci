package dev.lidia.mci.MyComponent;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraMCITest {

    @org.junit.jupiter.api.Test
    @DisplayName("testar que el resultado de la fórmula no de negativos y que devuelva el resultado de la fórmula IMC")
    public void testCalcularMCIValoresNormales() {
        // datos persona ficticia
        double peso = 70;
        double estatura = 1.75;
        double resultadoEsperado = peso / Math.pow(estatura, 2);

        // asignamos como concepto "resultado" al resultado de la formulación descrita
        // en la clase
        double resultado = CalculadoraMCI.calcularMCI(peso, estatura);

        // contraste que el resultado en sí sea el resultado ficticio esperado (0.01 es
        // una convención que se crea en formulación matemática como rango de error
        // mínimo)

        // 1.75 * 1.75 = 3.06 ---> 70 / 3.06 = 22.87 IMC
        assertThat(resultado, is(closeTo(resultadoEsperado, 0.01)));
    }

    // implementamos ejemplos ficticios de los posibles errores y plasticidad en
    // casos extremos para testar control de errores
    @org.junit.jupiter.api.Test
    @DisplayName("control de errores en valores introducidos")
    // creamos test independiente de métodos, inventamos nombre
    public void testCalcularValores_ExtremosErraticos() {

        // creamos un ficticio para cada extremo (delgadez severa/obesidad morbida)
        // [asegura que la función maneje los valores en límites del baremo normal de la
        // población y verifica que no hay errores con valores grandes o pequeños desde
        // punto vista matemático]
        double imc1 = CalculadoraMCI.calcularMCI(40, 1.60);
        double imc2 = CalculadoraMCI.calcularMCI(120, 2.00);

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
        Exception exception =assertThrows(IllegalArgumentException.class, () -> CalculadoraMCI.calcularMCI(-40, 1.60));
        assertEquals ("El valor del peso no puede ser negativo", exception.getMessage());
    }

}
