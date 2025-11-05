package Practica5;

public class Main {
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("  SISTEMA DE BIBLIOTECA UNIVERSITARIA - UMSA");
        System.out.println("====================================================\n");
        
        System.out.println("=== 1. COMPOSICION ===");
        System.out.println("(Pagina depende de Libro - Horario depende de Biblioteca)\n");
        
        Biblioteca bibliotecaCentral = new Biblioteca("Biblioteca Central UMSA");
        System.out.println("\n+ Biblioteca creada: " + bibliotecaCentral.getNombre());
        System.out.println("  (El Horario se crea automaticamente - COMPOSICION)");
        bibliotecaCentral.getHorario().mostrarHorario();
        
        System.out.println("\nCreando libros con sus paginas...");
        String[] paginas1 = {
            "Capitulo 1: Introduccion a Java",
            "Java es un lenguaje orientado a objetos",
            "Capitulo 2: Clases y Objetos"
        };
        Libro libro1 = new Libro("Programacion en Java", "978-123-456", paginas1);
        System.out.println("+ Libro creado con " + libro1.getNumeroPaginas() + " paginas (COMPOSICION)");
        
        String[] paginas2 = {
            "Capitulo 1: Listas",
            "Una lista es una estructura lineal"
        };
        Libro libro2 = new Libro("Estructuras de Datos", "978-789-012", paginas2);
        System.out.println("+ Libro creado con " + libro2.getNumeroPaginas() + " paginas");
        
        String[] paginas3 = {
            "Capitulo 1: Recursividad"
        };
        Libro libro3 = new Libro("Algoritmos Avanzados", "978-345-678", paginas3);
        System.out.println("+ Libro creado con " + libro3.getNumeroPaginas() + " paginas");
        
        System.out.println("\n=== 2. AGREGACION ===");
        System.out.println("(Libros y Autores existen independientemente)\n");
        
        Autor autor1 = new Autor("Gabriel Garcia Marquez", "Colombiano");
        Autor autor2 = new Autor("Mario Vargas Llosa", "Peruano");
        Autor autor3 = new Autor("Isabel Allende", "Chilena");
        
        System.out.println("+ Autores creados (existen independientemente)");
        
        System.out.println("\nAgregando a la biblioteca (AGREGACION):");
        bibliotecaCentral.agregarLibro(libro1);
        bibliotecaCentral.agregarLibro(libro2);
        bibliotecaCentral.agregarLibro(libro3);
        
        System.out.println();
        bibliotecaCentral.agregarAutor(autor1);
        bibliotecaCentral.agregarAutor(autor2);
        bibliotecaCentral.agregarAutor(autor3);
        
        System.out.println("\n=== 3. ASOCIACION ===");
        System.out.println("(Prestamo asocia Estudiante con Libro)\n");
        
        Estudiante estudiante1 = new Estudiante("202101234", "Juan Perez");
        Estudiante estudiante2 = new Estudiante("202105678", "Maria Rodriguez");
        
        System.out.println("+ Estudiantes creados");
        
        System.out.println("\nRealizando prestamos:");
        bibliotecaCentral.prestarLibro(estudiante1, libro1);
        bibliotecaCentral.prestarLibro(estudiante2, libro2);
        
        System.out.println("\n=== ESTADO DE LA BIBLIOTECA ===");
        bibliotecaCentral.mostrarEstado();
        
        System.out.println("\n=== LECTURA DE UN LIBRO ===");
        libro1.leer();
        
        System.out.println("\n=== CERRANDO BIBLIOTECA ===");
        System.out.println("(Los prestamos se destruyen - COMPOSICION)");
        System.out.println("(Los libros y autores siguen existiendo - AGREGACION)\n");
        
        bibliotecaCentral.cerrarBiblioteca();
        
        System.out.println("\nVerificacion despues del cierre:");
        System.out.println("+ Los libros siguen existiendo:");
        System.out.println("  * " + libro1.getTitulo());
        System.out.println("  * " + libro2.getTitulo());
        System.out.println("+ Los autores siguen existiendo:");
        System.out.println("  * " + autor1.getNombre());
        System.out.println("  * " + autor2.getNombre());
        
        bibliotecaCentral.mostrarEstado();
        
        System.out.println("\n====================================================");
        System.out.println("  RESUMEN DE RELACIONES");
        System.out.println("====================================================");
        System.out.println("COMPOSICION (dependencia fuerte):");
        System.out.println("  - Libro contiene Paginas");
        System.out.println("  - Biblioteca contiene Horario");
        System.out.println("  - Biblioteca contiene Prestamos");
        System.out.println("\nAGREGACION (dependencia debil):");
        System.out.println("  - Biblioteca referencia Libros");
        System.out.println("  - Biblioteca referencia Autores");
        System.out.println("\nASOCIACION (relacion simple):");
        System.out.println("  - Prestamo asocia Estudiante y Libro");
        System.out.println("====================================================");
    }
}
