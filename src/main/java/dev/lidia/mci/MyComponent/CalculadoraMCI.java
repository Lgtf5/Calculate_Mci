package dev.lidia.mci.MyComponent;

public class CalculadoraMCI {
    private double peso;
    private double estatura;
    private double mci;
    private String categoria;

    public CalculadoraMCI(double peso, double estatura) {
    
        
        if (peso <=0 || estatura <=0) {
            throw new IllegalArgumentException("El peso y la altura no pueden ser valores negativos, deben ser mayores que cero");
        }
        this.peso = peso;
        this.estatura = estatura;
        this.calcularMCI();
       
    }
    

    private void calcularMCI() {
        mci = peso / Math.pow(estatura, 2);
        categoria = CategoriaMCI.determinarCategoria(mci).name();
    }

    public double obtenerMCI() {
        return mci;
    }
    public String obtenerCategoria() {
        return categoria;
    }
        
    private enum CategoriaMCI {
        PESO_BAJO(0, 18.5),
        NORMAL(18.5, 24.9),
        SOBREPESO(25, 29.9);
        

        private final double minimoPeso;
        private final double maximoPeso;

        CategoriaMCI(double minimoPeso, double maximoPeso) {
            this.minimoPeso = minimoPeso;
            this.maximoPeso = maximoPeso;
        }

        public static CategoriaMCI determinarCategoria(double mci) {
            for (CategoriaMCI categoria : values()) {
                if (mci >= categoria.minimoPeso && mci < categoria.maximoPeso) {
                    return categoria;
                }
            }
            return SOBREPESO;
        }
    }

}    
    
    

    
