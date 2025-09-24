package Practica3;

import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinaNumero extends Juego {
    protected int numeroAAdivinar;
    private Scanner scanner;
    private Random random;
    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }
    public boolean validaNumero(int numero) {
        return numero >= 0 && numero <= 10;
    }
    public void juega() {
        reiniciaPartida();
        numeroAAdivinar = random.nextInt(11);
        System.out.println("Bienvenido al juego de adivinanza!");
        System.out.println("Adivina un numero entre 0 y 10");
        while (numeroDeVidas > 0) {
            System.out.print("Ingresa tu numero: ");
            int numeroIngresado = scanner.nextInt();
            if (!validaNumero(numeroIngresado)) {
                System.out.println("Numero invalido. Debe estar entre 0 y 10");
                continue;
            }
            if (numeroIngresado == numeroAAdivinar) {
                System.out.println("!!Acertaste!!");
                actualizaRecord();
                return;
            } else {
                if (quitaVida()) {
                    if (numeroIngresado < numeroAAdivinar) {
                        System.out.println("El numero a adivinar es mayor");
                    } else {
                        System.out.println("El numero a adivinar es menor");
                    }
                    System.out.println("Intentalo de nuevo");
                } else {
                    System.out.println("El numero era: " + numeroAAdivinar);
                    return;
                }
            }
        }
    }
}