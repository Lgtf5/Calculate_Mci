package dev.lidia.mci.MyComponent;

public class CalculadoraMCI {
    private double peso;
    private double estatura;
    private double mci;
    private String categoria;

    public CalculadoraMCI(double peso, double estatura) {
    
        //creamos la condición para no insertar datos negativos y, si se hace bien, que retorne resultado IMC
        if (peso <=0 || estatura <=0) {
            throw new IllegalArgumentException("El peso y la altura no pueden ser valores negativos, deben ser mayores que cero");
        }
        this.peso = peso;
        this.estatura = estatura;
        this.calcularMCI();
       
    }
    

    private void calcularMCI() {
        mci = peso / Math.pow(estatura, 2);
        determinarCategoria();
    }

    public double obtenerMCI() {
        return mci;
    }
    public String obtenerCategoria() {
        return categoria;
    }
        
    private void determinarCategoria() {

    }
    
}
    
