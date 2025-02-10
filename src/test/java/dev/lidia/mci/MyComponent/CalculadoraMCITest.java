package dev.lidia.mci.MyComponent;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CalculadoraMCITest {

    @org.junit.jupiter.api.Test
    @DisplayName ("testar que el resultado de la fórmula no de negativos y que devuelva el resultado de la fórmula IMC")
    public void testCalculadoraMCI() {
        //datos persona ficticia
        double peso= 70;
        double estatura= 1.75;
        double resultadoEsperado = peso / Math.pow (estatura, 2);

        //asignamos como concepto "resultado" al resultado de la formulación descrita en la clase
        double resultado = CalculadoraMCI.CalculadoraMCI(peso, estatura);

        //contraste que el resultado en sí sea el resultado ficticio esperado (0.01 es una convención que se crea en formulación matemática como rango de error mínimo)

        //1.75 * 1.75 = 3.06 ---> 70 / 3.06 = 22.87 IMC
        assertThat(resultado, is(closeTo(resultadoEsperado, 0.01)));
    }
    
}
