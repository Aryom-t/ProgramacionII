package Practica5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Estudiante estudiante;
    private Libro libro;
    
    public Prestamo(Estudiante estudiante, Libro libro) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = fechaPrestamo.plusDays(7);
    }
    
    public void mostrarInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\n=== INFORMACION DEL PRESTAMO ===");
        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("Codigo: " + estudiante.getCodigoEstudiante());
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("ISBN: " + libro.getIsbn());
        System.out.println("Fecha de prestamo: " + fechaPrestamo.format(formatter));
        System.out.println("Fecha de devolucion: " + fechaDevolucion.format(formatter));
        System.out.println("================================");
    }
    
    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    public Libro getLibro() {
        return libro;
    }
    
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
}
