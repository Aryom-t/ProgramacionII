package com.mycompany.practica6;

import java.util.Scanner;

/**
 * Interfaz de usuario con menú interactivo para el sistema de biblioteca
 * Permite agregar, consultar y gestionar libros, autores, estudiantes y préstamos
 */
public class MenuBiblioteca {
    
    private Biblioteca biblioteca;
    private Scanner scanner;
    
    public MenuBiblioteca() {
        this.biblioteca = new Biblioteca("Biblioteca Central UMSA");
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Inicia el sistema mostrando el menú principal
     */
    public void iniciar() {
        mostrarBienvenida();
        cargarDatosIniciales();
        menuPrincipal();
    }
    
    /**
     * Muestra el mensaje de bienvenida
     */
    private void mostrarBienvenida() {
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                                                        ║");
        System.out.println("║    SISTEMA DE BIBLIOTECA UNIVERSITARIA - UMSA          ║");
        System.out.println("║    Práctica 6: Persistencia de Objetos con JSON        ║");
        System.out.println("║                                                        ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    
    /**
     * Pregunta si desea cargar datos guardados anteriormente
     */
    private void cargarDatosIniciales() {
        if (biblioteca.existenDatosGuardados()) {
            System.out.println("📂 Se encontraron datos guardados anteriormente.");
            System.out.print("¿Desea cargar los datos guardados? (S/N): ");
            String respuesta = scanner.nextLine().trim().toUpperCase();
            
            if (respuesta.equals("S") || respuesta.equals("SI")) {
                biblioteca.cargarDatos();
            } else {
                System.out.println("✓ Iniciando con biblioteca vacía\n");
            }
        } else {
            System.out.println("ℹ No se encontraron datos guardados. Iniciando con biblioteca vacía.\n");
        }
    }
    
    /**
     * Muestra el menú principal y procesa las opciones
     */
    private void menuPrincipal() {
        boolean continuar = true;
        
        while (continuar) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1 -> menuLibros();
                case 2 -> menuAutores();
                case 3 -> menuEstudiantes();
                case 4 -> menuPrestamos();
                case 5 -> biblioteca.mostrarEstado();
                case 6 -> biblioteca.mostrarEstadoPersistencia();
                case 7 -> {
                    guardarYSalir();
                    continuar = false;
                }
                case 8 -> {
                    salirSinGuardar();
                    continuar = false;
                }
                default -> System.out.println("❌ Opción inválida. Intente de nuevo.");
            }
        }
    }
    
    /**
     * Muestra las opciones del menú principal
     */
    private void mostrarMenuPrincipal() {
        System.out.println("\n════════════════════════════════════════════");
        System.out.println("           MENÚ PRINCIPAL");
        System.out.println("════════════════════════════════════════════");
        System.out.println("1. 📚 Gestión de Libros");
        System.out.println("2. ✍️  Gestión de Autores");
        System.out.println("3. 👤 Gestión de Estudiantes");
        System.out.println("4. 📋 Gestión de Préstamos");
        System.out.println("5. 📊 Ver Estado de la Biblioteca");
        System.out.println("6. 💾 Ver Estado de Persistencia");
        System.out.println("7. 💾 Guardar y Salir");
        System.out.println("8. 🚪 Salir sin Guardar");
        System.out.println("════════════════════════════════════════════");
        System.out.print("Seleccione una opción: ");
    }
    
    // ==================== MENÚ DE LIBROS ====================
    
    private void menuLibros() {
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\n════════════════════════════════════════════");
            System.out.println("         GESTIÓN DE LIBROS");
            System.out.println("════════════════════════════════════════════");
            System.out.println("1. ➕ Agregar nuevo libro");
            System.out.println("2. 📖 Listar todos los libros");
            System.out.println("3. 🔍 Buscar libro por título");
            System.out.println("4. 📄 Leer un libro");
            System.out.println("5. ⬅️  Volver al menú principal");
            System.out.println("════════════════════════════════════════════");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1 -> agregarLibro();
                case 2 -> listarLibros();
                case 3 -> buscarLibro();
                case 4 -> leerLibro();
                case 5 -> volver = true;
                default -> System.out.println("❌ Opción inválida.");
            }
        }
    }
    
    private void agregarLibro() {
        System.out.println("\n--- AGREGAR NUEVO LIBRO ---");
        
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        
        System.out.print("Número de páginas: ");
        int numPaginas = leerEntero();
        scanner.nextLine(); // Limpiar buffer
        
        String[] contenidoPaginas = new String[numPaginas];
        for (int i = 0; i < numPaginas; i++) {
            System.out.print("Contenido de la página " + (i + 1) + ": ");
            contenidoPaginas[i] = scanner.nextLine();
        }
        
        Libro libro = new Libro(titulo, isbn, contenidoPaginas);
        biblioteca.agregarLibro(libro);
    }
    
    private void listarLibros() {
        System.out.println("\n════════════════════════════════════════════");
        System.out.println("         LISTA DE LIBROS");
        System.out.println("════════════════════════════════════════════");
        
        if (biblioteca.getLibros().isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            int contador = 1;
            for (Libro libro : biblioteca.getLibros()) {
                System.out.println(contador + ". " + libro.getTitulo());
                System.out.println("   ISBN: " + libro.getIsbn());
                System.out.println("   Páginas: " + libro.getNumeroPaginas());
                System.out.println();
                contador++;
            }
        }
    }
    
    private void buscarLibro() {
        System.out.print("\nIngrese el título a buscar: ");
        String busqueda = scanner.nextLine().toLowerCase();
        
        boolean encontrado = false;
        for (Libro libro : biblioteca.getLibros()) {
            if (libro.getTitulo().toLowerCase().contains(busqueda)) {
                System.out.println("\n✓ Libro encontrado:");
                System.out.println("  Título: " + libro.getTitulo());
                System.out.println("  ISBN: " + libro.getIsbn());
                System.out.println("  Páginas: " + libro.getNumeroPaginas());
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("❌ No se encontraron libros con ese título.");
        }
    }
    
    private void leerLibro() {
        if (biblioteca.getLibros().isEmpty()) {
            System.out.println("❌ No hay libros disponibles para leer.");
            return;
        }
        
        listarLibros();
        System.out.print("Seleccione el número del libro a leer: ");
        int indice = leerEntero() - 1;
        scanner.nextLine(); // Limpiar buffer
        
        if (indice >= 0 && indice < biblioteca.getLibros().size()) {
            biblioteca.getLibros().get(indice).leer();
        } else {
            System.out.println("❌ Número inválido.");
        }
    }
    
    // ==================== MENÚ DE AUTORES ====================
    
    private void menuAutores() {
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\n════════════════════════════════════════════");
            System.out.println("         GESTIÓN DE AUTORES");
            System.out.println("════════════════════════════════════════════");
            System.out.println("1. ➕ Agregar nuevo autor");
            System.out.println("2. 📋 Listar todos los autores");
            System.out.println("3. ⬅️  Volver al menú principal");
            System.out.println("════════════════════════════════════════════");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1 -> agregarAutor();
                case 2 -> listarAutores();
                case 3 -> volver = true;
                default -> System.out.println("❌ Opción inválida.");
            }
        }
    }
    
    private void agregarAutor() {
        System.out.println("\n--- AGREGAR NUEVO AUTOR ---");
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        
        Autor autor = new Autor(nombre, nacionalidad);
        biblioteca.agregarAutor(autor);
    }
    
    private void listarAutores() {
        System.out.println("\n════════════════════════════════════════════");
        System.out.println("         LISTA DE AUTORES");
        System.out.println("════════════════════════════════════════════");
        
        if (biblioteca.getAutores().isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            int contador = 1;
            for (Autor autor : biblioteca.getAutores()) {
                System.out.println(contador + ". " + autor.getNombre() + 
                                 " (" + autor.getNacionalidad() + ")");
                contador++;
            }
        }
    }
    
    // ==================== MENÚ DE ESTUDIANTES ====================
    
    private void menuEstudiantes() {
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\n════════════════════════════════════════════");
            System.out.println("         GESTIÓN DE ESTUDIANTES");
            System.out.println("════════════════════════════════════════════");
            System.out.println("1. ➕ Agregar nuevo estudiante");
            System.out.println("2. 📋 Listar todos los estudiantes");
            System.out.println("3. ⬅️  Volver al menú principal");
            System.out.println("════════════════════════════════════════════");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1 -> agregarEstudiante();
                case 2 -> listarEstudiantes();
                case 3 -> volver = true;
                default -> System.out.println("❌ Opción inválida.");
            }
        }
    }
    
    private void agregarEstudiante() {
        System.out.println("\n--- AGREGAR NUEVO ESTUDIANTE ---");
        
        System.out.print("Código de estudiante: ");
        String codigo = scanner.nextLine();
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        Estudiante estudiante = new Estudiante(codigo, nombre);
        biblioteca.agregarEstudiante(estudiante);
    }
    
    private void listarEstudiantes() {
        System.out.println("\n════════════════════════════════════════════");
        System.out.println("         LISTA DE ESTUDIANTES");
        System.out.println("════════════════════════════════════════════");
        
        if (biblioteca.getEstudiantes().isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            int contador = 1;
            for (Estudiante est : biblioteca.getEstudiantes()) {
                System.out.println(contador + ". " + est.getNombre() + 
                                 " - Código: " + est.getCodigoEstudiante());
                contador++;
            }
        }
    }
    
    // ==================== MENÚ DE PRÉSTAMOS ====================
    
    private void menuPrestamos() {
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\n════════════════════════════════════════════");
            System.out.println("         GESTIÓN DE PRÉSTAMOS");
            System.out.println("════════════════════════════════════════════");
            System.out.println("1. ➕ Realizar nuevo préstamo");
            System.out.println("2. 📋 Listar préstamos activos");
            System.out.println("3. ⬅️  Volver al menú principal");
            System.out.println("════════════════════════════════════════════");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1 -> realizarPrestamo();
                case 2 -> listarPrestamos();
                case 3 -> volver = true;
                default -> System.out.println("❌ Opción inválida.");
            }
        }
    }
    
    private void realizarPrestamo() {
        if (biblioteca.getEstudiantes().isEmpty()) {
            System.out.println("❌ No hay estudiantes registrados. Agregue estudiantes primero.");
            return;
        }
        
        if (biblioteca.getLibros().isEmpty()) {
            System.out.println("❌ No hay libros disponibles. Agregue libros primero.");
            return;
        }
        
        System.out.println("\n--- REALIZAR NUEVO PRÉSTAMO ---");
        
        // Seleccionar estudiante
        listarEstudiantes();
        System.out.print("\nSeleccione el número del estudiante: ");
        int indiceEst = leerEntero() - 1;
        scanner.nextLine(); // Limpiar buffer
        
        if (indiceEst < 0 || indiceEst >= biblioteca.getEstudiantes().size()) {
            System.out.println("❌ Número inválido.");
            return;
        }
        
        // Seleccionar libro
        listarLibros();
        System.out.print("\nSeleccione el número del libro: ");
        int indiceLibro = leerEntero() - 1;
        scanner.nextLine(); // Limpiar buffer
        
        if (indiceLibro < 0 || indiceLibro >= biblioteca.getLibros().size()) {
            System.out.println("❌ Número inválido.");
            return;
        }
        
        Estudiante estudiante = biblioteca.getEstudiantes().get(indiceEst);
        Libro libro = biblioteca.getLibros().get(indiceLibro);
        
        biblioteca.prestarLibro(estudiante, libro);
    }
    
    private void listarPrestamos() {
        System.out.println("\n════════════════════════════════════════════");
        System.out.println("         PRÉSTAMOS ACTIVOS");
        System.out.println("════════════════════════════════════════════");
        
        if (biblioteca.getPrestamosActivos().isEmpty()) {
            System.out.println("No hay préstamos activos.");
        } else {
            for (Prestamo prestamo : biblioteca.getPrestamosActivos()) {
                prestamo.mostrarInfo();
            }
        }
    }
    
    // ==================== GUARDAR Y SALIR ====================
    
    private void guardarYSalir() {
        System.out.println("\n💾 Guardando datos...");
        biblioteca.guardarDatos();
        System.out.println("\n👋 ¡Gracias por usar el Sistema de Biblioteca UMSA!");
        System.out.println("════════════════════════════════════════════\n");
    }
    
    private void salirSinGuardar() {
        System.out.print("\n⚠️  ¿Está seguro que desea salir sin guardar? (S/N): ");
        String respuesta = scanner.nextLine().trim().toUpperCase();
        
        if (respuesta.equals("S") || respuesta.equals("SI")) {
            System.out.println("\n👋 Saliendo sin guardar. ¡Hasta pronto!");
            System.out.println("════════════════════════════════════════════\n");
        } else {
            guardarYSalir();
        }
    }
    
    // ==================== UTILIDADES ====================
    
    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private int leerEntero() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar buffer
            return -1;
        }
    }
}
