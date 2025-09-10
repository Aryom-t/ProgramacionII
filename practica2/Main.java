package Practica2;

public class Main {

    public static void main(String[] args) {
                System.out.println("=== PRUEBAS PROBLEMA 1: ALGEBRA VECTORIAL ===");
                
                Vector3D a = new Vector3D(1, 0, 0);
                Vector3D b = new Vector3D(0, 1, 0);
                AlgebraVectorial algebra = new AlgebraVectorial(a, b);
                
                System.out.println("Vector A: " + a);
                System.out.println("Vector B: " + b);
                
                System.out.println("\n--- Pruebas de Perpendicularidad ---");
                System.out.println("Perpendicular (|a+b| = |a-b|): " + algebra.perpendicular());
                System.out.println("Perpendicular (a·b = 0): " + algebra.perpendicular(a, b));
                System.out.println("Perpendicular (|a+b|² = |a|²+|b|²): " + algebra.perpendicular(0.0));
                
                System.out.println("\n--- Pruebas de Paralelismo ---");
                Vector3D c = new Vector3D(2, 0, 0);
                Vector3D d = new Vector3D(4, 0, 0);
                AlgebraVectorial algebraParalela = new AlgebraVectorial(c, d);
                System.out.println("Vector C: " + c);
                System.out.println("Vector D: " + d);
                System.out.println("Paralela (a = rb): " + algebraParalela.paralela());
                System.out.println("Paralela (a×b = 0): " + algebraParalela.paralela(true));
                
                System.out.println("\n--- Proyección y Componente ---");
                try {
                        Vector3D proyeccion = algebra.proyeccion();
                        System.out.println("Proyección de A sobre B: " + proyeccion);
                        double componente = algebra.componente();
                        System.out.println("Componente de A en B: " + componente);
                } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                }
                
                System.out.println("\n=== PRUEBAS PROBLEMA 2: VECTOR3D COMPLETO ===");
                
                Vector3DCompleto v1 = new Vector3DCompleto(1, 2, 3);
                Vector3DCompleto v2 = new Vector3DCompleto(4, 5, 6);
                
                System.out.println("Vector v1: " + v1);
                System.out.println("Vector v2: " + v2);
                
                System.out.println("\n--- Operaciones Básicas ---");
                System.out.println("Suma: " + v1.suma(v2));
                System.out.println("Multiplicación por escalar (2): " + v1.multiplicar(2));
                System.out.println("Longitud de v1: " + String.format("%.3f", v1.longitud()));
                System.out.println("Vector normalizado v1: " + v1.normalizar());
                
                System.out.println("\n--- Productos ---");
                System.out.println("Producto escalar: " + v1.productoEscalar(v2));
                System.out.println("Producto vectorial: " + v1.productoVectorial(v2));
                
                System.out.println("\n--- Verificaciones ---");
                Vector3DCompleto normalizado = v1.normalizar();
                System.out.println("Longitud del vector normalizado: " + String.format("%.10f", normalizado.longitud()));
                
                Vector3DCompleto i = new Vector3DCompleto(1, 0, 0);
                Vector3DCompleto j = new Vector3DCompleto(0, 1, 0);
                Vector3DCompleto k = new Vector3DCompleto(0, 0, 1);
                System.out.println("i × j = " + i.productoVectorial(j) + " (debe ser k)");
                System.out.println("i · j = " + i.productoEscalar(j) + " (debe ser 0)");
        }
}
