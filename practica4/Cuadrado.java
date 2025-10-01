package Practica4;

/**
 * Clase Cuadrado
 * @author ray-r
 */
class Cuadrado extends Figura implements Coloreado {
    private double lado;
    
    public Cuadrado(double lado, String color) {
        this.lado = lado;
        this.color = color;
    }
    
    @Override
    public double area() {
        return lado * lado;
    }
    
    @Override
    public double perimetro() {
        return 4 * lado;
    }
    
    @Override
    public String comoColorear() {
        return "Colorear los cuatro lados";
    }
    
    @Override
    public String toString() {
        return "CUADRADO\n" +
               "Lado: " + String.format("%.2f", lado) + "\n" +
               super.toString();
    }
}