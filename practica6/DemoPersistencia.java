package com.mycompany.practica6;

/**
 * Clase para demostrar el funcionamiento de la persistencia
 * Este archivo carga datos de ejemplo para probar el sistema
 */
public class DemoPersistencia {
    
    public static void cargarDatosEjemplo(Biblioteca biblioteca) {
        System.out.println("\n📦 Cargando datos de ejemplo...\n");
        
        // Agregar libros de ejemplo
        String[] paginas1 = {
            "Capítulo 1: Introducción a Java",
            "Java es un lenguaje orientado a objetos multiplataforma",
            "Capítulo 2: Clases y Objetos",
            "Las clases son plantillas para crear objetos"
        };
        Libro libro1 = new Libro("Programación en Java", "978-123-456", paginas1);
        biblioteca.agregarLibro(libro1);
        
        String[] paginas2 = {
            "Capítulo 1: Listas Enlazadas",
            "Una lista es una estructura de datos lineal",
            "Capítulo 2: Pilas y Colas"
        };
        Libro libro2 = new Libro("Estructuras de Datos", "978-789-012", paginas2);
        biblioteca.agregarLibro(libro2);
        
        String[] paginas3 = {
            "Capítulo 1: Algoritmos de Ordenamiento",
            "QuickSort, MergeSort, BubbleSort"
        };
        Libro libro3 = new Libro("Algoritmos Avanzados", "978-345-678", paginas3);
        biblioteca.agregarLibro(libro3);
        
        String[] paginas4 = {
            "Capítulo 1: Bases de Datos Relacionales",
            "SQL y diseño de esquemas",
            "Capítulo 2: Normalización"
        };
        Libro libro4 = new Libro("Fundamentos de Bases de Datos", "978-111-222", paginas4);
        biblioteca.agregarLibro(libro4);
        
        // Agregar autores de ejemplo
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiano");
        biblioteca.agregarAutor(autor1);
        
        Autor autor2 = new Autor("Mario Vargas Llosa", "Peruano");
        biblioteca.agregarAutor(autor2);
        
        Autor autor3 = new Autor("Isabel Allende", "Chilena");
        biblioteca.agregarAutor(autor3);
        
        Autor autor4 = new Autor("Jorge Luis Borges", "Argentino");
        biblioteca.agregarAutor(autor4);
        
        // Agregar estudiantes de ejemplo
        Estudiante est1 = new Estudiante("202101234", "Juan Pérez Mamani");
        biblioteca.agregarEstudiante(est1);
        
        Estudiante est2 = new Estudiante("202105678", "María Rodríguez Quispe");
        biblioteca.agregarEstudiante(est2);
        
        Estudiante est3 = new Estudiante("202109876", "Carlos López Condori");
        biblioteca.agregarEstudiante(est3);
        
        // Realizar algunos préstamos
        System.out.println("\n📋 Realizando préstamos de ejemplo...\n");
        biblioteca.prestarLibro(est1, libro1);
        biblioteca.prestarLibro(est2, libro2);
        biblioteca.prestarLibro(est3, libro4);
        
        System.out.println("\n✅ Datos de ejemplo cargados exitosamente");
        System.out.println("   - 4 Libros");
        System.out.println("   - 4 Autores");
        System.out.println("   - 3 Estudiantes");
        System.out.println("   - 3 Préstamos activos\n");
    }
    
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║   DEMOSTRACIÓN DE PERSISTENCIA CON GSON                ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central UMSA");
        
        // Cargar datos de ejemplo
        cargarDatosEjemplo(biblioteca);
        
        // Mostrar estado
        biblioteca.mostrarEstado();
        
        // Guardar todos los datos en JSON
        System.out.println("\n💾 Guardando datos en archivos JSON...");
        biblioteca.guardarDatos();
        
        // Mostrar estado de persistencia
        biblioteca.mostrarEstadoPersistencia();
        
        // Crear una nueva instancia y cargar datos
        System.out.println("\n🔄 Simulando reinicio del sistema...");
        Biblioteca bibliotecaNueva = new Biblioteca("Biblioteca Central UMSA");
        bibliotecaNueva.cargarDatos();
        
        // Mostrar datos cargados
        bibliotecaNueva.mostrarEstado();
        
        System.out.println("\n✅ DEMOSTRACIÓN COMPLETADA");
        System.out.println("════════════════════════════════════════════════════════");
        System.out.println("Los archivos JSON fueron creados en: datos_biblioteca/");
        System.out.println("- libros.json");
        System.out.println("- autores.json");
        System.out.println("- estudiantes.json");
        System.out.println("- prestamos.json");
        System.out.println("════════════════════════════════════════════════════════\n");
    }
}
