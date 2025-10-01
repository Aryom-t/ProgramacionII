package Practica4;

import java.util.Random;

/**
 * Programa principal para el Ejercicio 2: Sistema de Figuras Geometricas
 * @author ray-r
 */
public class Main2 {
    public static void main(String[] args) {
        Random random = new Random();
        Figura[] figuras = new Figura[5];
        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo", "Naranja", "Morado"};
        
        System.out.println("=== GENERACION DE FIGURAS ALEATORIAS ===\n");
        
        // Generar 5 figuras aleatorias
        for (int i = 0; i < 5; i++) {
            int tipoFigura = random.nextInt(2) + 1; // 1 o 2
            String color = colores[random.nextInt(colores.length)];
            
            if (tipoFigura == 1) {
                // Crear Cuadrado con lado aleatorio entre 1 y 10
                double lado = 1 + random.nextDouble() * 9;
                figuras[i] = new Cuadrado(lado, color);
            } else {
                // Crear Circulo con radio aleatorio entre 1 y 10
                double radio = 1 + random.nextDouble() * 9;
                figuras[i] = new Circulo(radio, color);
            }
        }
        
        // Mostrar informacion de todas las figuras
        System.out.println("=== INFORMACION DE LAS FIGURAS ===\n");
        for (int i = 0; i < figuras.length; i++) {
            System.out.println("Figura " + (i + 1) + ":");
            System.out.println(figuras[i].toString());
            System.out.println("Area: " + String.format("%.2f", figuras[i].area()));
            System.out.println("Perimetro: " + String.format("%.2f", figuras[i].perimetro()));
            
            // Verificar si implementa Coloreado
            if (figuras[i] instanceof Coloreado) {
                Coloreado objetoColoreado = (Coloreado) figuras[i];
                System.out.println("Como colorear: " + objetoColoreado.comoColorear());
            }
            
            System.out.println("========================================\n");
        }
    }
}