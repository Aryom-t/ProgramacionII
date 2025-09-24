package Practica3;

public class Juego {

    protected int numeroDeVidas;
    protected int record;

    public Juego(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
        this.record = 0;
    }

    public void reiniciaPartida() {
        this.numeroDeVidas = 3; 
    }

    public void actualizaRecord() {
        record++;
        System.out.println("Record actualizado! Victorias: " + record);
    }

    public boolean quitaVida() {
        numeroDeVidas--;
        if (numeroDeVidas > 0) {
            System.out.println("Te quedan " + numeroDeVidas + " vidas");
            return true;
        } else {
            System.out.println("Game Over! No te quedan mas vidas");
            return false;
        }
    }
}
