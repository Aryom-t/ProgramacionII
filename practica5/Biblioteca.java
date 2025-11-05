package Practica5;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Libro> libros;
    private List<Autor> autores;
    private List<Prestamo> prestamosActivos;
    private Horario horario;
    
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamosActivos = new ArrayList<>();
        this.horario = new Horario("Lunes a Viernes", "08:00", "20:00");
    }
    
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("+ Libro agregado: " + libro.getTitulo());
    }
    
    public void agregarAutor(Autor autor) {
        autores.add(autor);
        System.out.println("+ Autor registrado: " + autor.getNombre());
    }
    
    public void prestarLibro(Estudiante estudiante, Libro libro) {
        if (!libros.contains(libro)) {
            System.out.println("X Error: El libro no esta disponible en la biblioteca");
            return;
        }
        Prestamo prestamo = new Prestamo(estudiante, libro);
        prestamosActivos.add(prestamo);
        System.out.println("\nPrestamo realizado exitosamente");
        prestamo.mostrarInfo();
    }
    
    public void mostrarEstado() {
        System.out.println("\n========================================");
        System.out.println("ESTADO DE LA BIBLIOTECA: " + nombre);
        System.out.println("========================================");
        
        horario.mostrarHorario();
        
        System.out.println("\n--- Libros Disponibles (" + libros.size() + ") ---");
        for (Libro libro : libros) {
            System.out.println("  * " + libro.getTitulo() + " - ISBN: " + libro.getIsbn());
        }
        
        System.out.println("\n--- Autores Registrados (" + autores.size() + ") ---");
        for (Autor autor : autores) {
            System.out.println("  * " + autor.getNombre() + " (" + autor.getNacionalidad() + ")");
        }
        
        System.out.println("\n--- Prestamos Activos (" + prestamosActivos.size() + ") ---");
        if (prestamosActivos.isEmpty()) {
            System.out.println("  (No hay prestamos activos)");
        } else {
            for (Prestamo prestamo : prestamosActivos) {
                System.out.println("  * " + prestamo.getEstudiante().getNombre() + 
                                 " -> " + prestamo.getLibro().getTitulo());
            }
        }
        
        System.out.println("========================================");
    }
    
    public void cerrarBiblioteca() {
        System.out.println("\n========================================");
        System.out.println("CERRANDO BIBLIOTECA: " + nombre);
        System.out.println("========================================");
        prestamosActivos.clear();
        System.out.println("- Todos los prestamos han sido finalizados");
        System.out.println("- El horario ha sido eliminado");
        System.out.println("+ Los libros y autores siguen existiendo");
        System.out.println("========================================");
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public Horario getHorario() {
        return horario;
    }
}
