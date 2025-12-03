package com.mycompany.practica6;

public class Horario {
    private String diasApertura;
    private String horaApertura;
    private String horaCierre;
    
    public Horario(String diasApertura, String horaApertura, String horaCierre) {
        this.diasApertura = diasApertura;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }
    
    public void mostrarHorario() {
        System.out.println("\n=== HORARIO DE ATENCION ===");
        System.out.println("Dias: " + diasApertura);
        System.out.println("Horario: " + horaApertura + " - " + horaCierre);
        System.out.println("===========================");
    }
    
    public String getDiasApertura() {
        return diasApertura;
    }
    
    public String getHoraApertura() {
        return horaApertura;
    }
    
    public String getHoraCierre() {
        return horaCierre;
    }
}
