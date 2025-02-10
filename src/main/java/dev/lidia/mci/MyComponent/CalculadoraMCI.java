package dev.lidia.mci.MyComponent;

public class CalculadoraMCI {
    public static double calcularMCI(double peso, double estatura){
        //creamos la condición para no insertar datos negativos y, si se hace bien, que retorne resultado IMC
        if (peso <0 || estatura <=0) {
            throw new IllegalArgumentException("El peso y la altura no pueden ser valores negativos, deben ser mayores que cero");
        } return peso / Math.pow(estatura, 2);
    }
    public static String resultadosPorCategoria() {
        
    }
}