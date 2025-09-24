package Practica3;
import java.util.Random;
import java.util.Scanner;
public class JuegoAdivinaImpar extends JuegoAdivinaNumero {
    public JuegoAdivinaImpar(int numeroDeVidas) {
        super(numeroDeVidas);}
    public boolean validaNumero(int numero) {
        if (numero < 0 || numero > 10) {
            return false;}
        if (numero % 2 == 0) {
            System.out.println("Error: El numero debe ser impar");
            return false;}
        return true;}
    public void juega() {
        reiniciaPartida();
        int[] numerosImpares = {1, 3, 5, 7, 9};
        numeroAAdivinar = numerosImpares[new Random().nextInt(numerosImpares.length)];
        System.out.println("Bienvenido al juego de adivinanza de numeros IMPARES!");
        System.out.println("Adivina un numero IMPAR entre 0 y 10");
        Scanner scanner = new Scanner(System.in);
        while (numeroDeVidas > 0) {
            System.out.print("Ingresa tu numero impar: ");
            int numeroIngresado = scanner.nextInt();
            if (!validaNumero(numeroIngresado)) {
                continue;
            }
            if (numeroIngresado == numeroAAdivinar) {
                System.out.println("Acertaste!!");
                actualizaRecord();
                return;
            } else {
                if (quitaVida()) {
                    if (numeroIngresado < numeroAAdivinar) {
                        System.out.println("El numero impar a adivinar es mayor");
                    } else {
                        System.out.println("El numero impar a adivinar es menor");
                    }
                    System.out.println("Intentalo de nuevo");
                } else {
                    System.out.println("El numero impar era: " + numeroAAdivinar);
                    return;
                }
            }
        }
    }
}
