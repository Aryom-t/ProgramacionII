package Practica3;

public class Aplicacion {

    public static void main(String[] args) {
        System.out.println("=== JUEGOS DE ADIVINANZA ===\n");

        JuegoAdivinaNumero juegoNormal = new JuegoAdivinaNumero(3);
        JuegoAdivinaPar juegoPar = new JuegoAdivinaPar(3);
        JuegoAdivinaImpar juegoImpar = new JuegoAdivinaImpar(3);

        System.out.println("--- JUEGO 1: NUMEROS NORMALES ---");
        juegoNormal.juega();

        System.out.println("\n--- JUEGO 2: NUMEROS PARES ---");
        juegoPar.juega();

        System.out.println("\n--- JUEGO 3: NUMEROS IMPARES ---");
        juegoImpar.juega();

        System.out.println("\n¡Gracias por jugar!");
    }

}
