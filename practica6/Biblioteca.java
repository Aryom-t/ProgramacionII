package com.mycompany.practica6;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Libro> libros;
    private List<Autor> autores;
    private List<Estudiante> estudiantes;
    private List<Prestamo> prestamosActivos;
    private Horario horario;
    private GestorPersistencia gestorPersistencia;
    
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.prestamosActivos = new ArrayList<>();
        this.horario = new Horario("Lunes a Viernes", "08:00", "20:00");
        this.gestorPersistencia = new GestorPersistencia();
    }
    
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("+ Libro agregado: " + libro.getTitulo());
    }
    
    public void agregarAutor(Autor autor) {
        autores.add(autor);
        System.out.println("+ Autor registrado: " + autor.getNombre());
    }
    
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        System.out.println("+ Estudiante registrado: " + estudiante.getNombre());
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
    
    public List<Libro> getLibros() {
        return libros;
    }
    
    public List<Autor> getAutores() {
        return autores;
    }
    
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }
    
    public void guardarDatos() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   GUARDANDO DATOS DE LA BIBLIOTECA         ║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        gestorPersistencia.guardarLibros(libros);
        gestorPersistencia.guardarAutores(autores);
        gestorPersistencia.guardarEstudiantes(estudiantes);
        gestorPersistencia.guardarPrestamos(prestamosActivos);
        
        System.out.println("\n✓ Todos los datos han sido guardados exitosamente");
        System.out.println("════════════════════════════════════════════\n");
    }
    
    public void cargarDatos() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   CARGANDO DATOS DE LA BIBLIOTECA          ║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        List<Libro> librosC = gestorPersistencia.cargarLibros();
        if (librosC != null) {
            this.libros = librosC;
        }
        
        List<Autor> autoresC = gestorPersistencia.cargarAutores();
        if (autoresC != null) {
            this.autores = autoresC;
        }
        
        List<Estudiante> estudiantesC = gestorPersistencia.cargarEstudiantes();
        if (estudiantesC != null) {
            this.estudiantes = estudiantesC;
        }
        
        List<Prestamo> prestamosC = gestorPersistencia.cargarPrestamos();
        if (prestamosC != null) {
            this.prestamosActivos = prestamosC;
        }
        
        System.out.println("\n✓ Datos cargados - Libros: " + libros.size() + 
                          ", Autores: " + autores.size() + 
                          ", Estudiantes: " + estudiantes.size() +
                          ", Prestamos: " + prestamosActivos.size());
        System.out.println("════════════════════════════════════════════\n");
    }
    
    public boolean existenDatosGuardados() {
        return gestorPersistencia.existenDatosGuardados();
    }
    
    public void mostrarEstadoPersistencia() {
        gestorPersistencia.mostrarEstadoPersistencia();
    }
}
