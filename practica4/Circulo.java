package Practica4;

class Circulo extends Figura {
    private double radio;
    
    public Circulo(double radio, String color) {
        this.radio = radio;
        this.color = color;
    }
    
    @Override
    public double area() {
        return Math.PI * radio * radio;
    }
    
    @Override
    public double perimetro() {
        return 2 * Math.PI * radio;
    }
    
    @Override
    public String toString() {
        return "CIRCULO\n" +
               "Radio: " + String.format("%.2f", radio) + "\n" +
               super.toString();
    }
}