package Practica3;
import java.util.Random;
import java.util.Scanner;
public class JuegoAdivinaPar extends JuegoAdivinaNumero {
    public JuegoAdivinaPar(int numeroDeVidas) {
        super(numeroDeVidas);}
    public boolean validaNumero(int numero) {
        if (numero < 0 || numero > 10) {
            return false;
        }
        if (numero % 2 != 0) {
            System.out.println("Error: El numero debe ser par");
            return false;
        }
        return true;
    }
    public void juega() {
        reiniciaPartida();
        int[] numerosPares = {0, 2, 4, 6, 8, 10};
        numeroAAdivinar = numerosPares[new Random().nextInt(numerosPares.length)];
        System.out.println("Bienvenido al juego de adivinanza de numeros PARES!");
        System.out.println("Adivina un numero PAR entre 0 y 10");
        Scanner scanner = new Scanner(System.in);
        while (numeroDeVidas > 0) {
            System.out.print("Ingresa tu numero par: ");
            int numeroIngresado = scanner.nextInt();

            if (!validaNumero(numeroIngresado)) {
                continue;
            }
            if (numeroIngresado == numeroAAdivinar) {
                System.out.println("!!Acertaste!!");
                actualizaRecord();
                return;
            } else {
                if (quitaVida()) {
                    if (numeroIngresado < numeroAAdivinar) {
                        System.out.println("El numero par a adivinar es mayor");
                    } else {
                        System.out.println("El numero par a adivinar es menor");
                    }
                    System.out.println("Intentalo de nuevo");
                } else {
                    System.out.println("El numero par era: " + numeroAAdivinar);
                    return;
                }
            }
        }
    }
}
