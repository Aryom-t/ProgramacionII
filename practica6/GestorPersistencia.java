package com.mycompany.practica6;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

package com.mycompany.practica6;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestorPersistencia {
    
    private static final String DIRECTORIO_DATOS = "datos_biblioteca";
    private static final String ARCHIVO_LIBROS = DIRECTORIO_DATOS + "/libros.json";
    private static final String ARCHIVO_AUTORES = DIRECTORIO_DATOS + "/autores.json";
    private static final String ARCHIVO_ESTUDIANTES = DIRECTORIO_DATOS + "/estudiantes.json";
    private static final String ARCHIVO_PRESTAMOS = DIRECTORIO_DATOS + "/prestamos.json";
    
    private Gson gson;
    
    public GestorPersistencia() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd")
                .create();
        
        crearDirectorio();
    }
    
    private void crearDirectorio() {
        try {
            File directorio = new File(DIRECTORIO_DATOS);
            if (!directorio.exists()) {
                directorio.mkdirs();
                System.out.println("✓ Directorio de datos creado: " + DIRECTORIO_DATOS);
            }
        } catch (Exception e) {
            System.err.println("✗ Error al crear directorio: " + e.getMessage());
        }
    }
    
    public void guardarLibros(List<Libro> libros) {
        guardarJSON(libros, ARCHIVO_LIBROS, "Libros");
    }
    
    public void guardarAutores(List<Autor> autores) {
        guardarJSON(autores, ARCHIVO_AUTORES, "Autores");
    }
    
    public void guardarEstudiantes(List<Estudiante> estudiantes) {
        guardarJSON(estudiantes, ARCHIVO_ESTUDIANTES, "Estudiantes");
    }
    
    public void guardarPrestamos(List<Prestamo> prestamos) {
        guardarJSON(prestamos, ARCHIVO_PRESTAMOS, "Prestamos");
    }
    
    private <T> void guardarJSON(T objeto, String rutaArchivo, String tipoObjeto) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);
            System.out.println("✓ " + tipoObjeto + " guardados exitosamente en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("✗ Error al guardar " + tipoObjeto + ": " + e.getMessage());
        }
    }
    
    public List<Libro> cargarLibros() {
        Type tipoLista = new TypeToken<ArrayList<Libro>>(){}.getType();
        return cargarJSON(ARCHIVO_LIBROS, tipoLista, "Libros");
    }
    
    public List<Autor> cargarAutores() {
        Type tipoLista = new TypeToken<ArrayList<Autor>>(){}.getType();
        return cargarJSON(ARCHIVO_AUTORES, tipoLista, "Autores");
    }
    
    public List<Estudiante> cargarEstudiantes() {
        Type tipoLista = new TypeToken<ArrayList<Estudiante>>(){}.getType();
        return cargarJSON(ARCHIVO_ESTUDIANTES, tipoLista, "Estudiantes");
    }
    
    public List<Prestamo> cargarPrestamos() {
        Type tipoLista = new TypeToken<ArrayList<Prestamo>>(){}.getType();
        return cargarJSON(ARCHIVO_PRESTAMOS, tipoLista, "Prestamos");
    }
    
    private <T> T cargarJSON(String rutaArchivo, Type tipo, String tipoObjeto) {
        try {
            File archivo = new File(rutaArchivo);
            if (!archivo.exists()) {
                System.out.println("ℹ No se encontro archivo de " + tipoObjeto + ", creando nueva lista vacia");
                return null;
            }
            
            String contenidoJson = new String(Files.readAllBytes(Paths.get(rutaArchivo)));
            T resultado = gson.fromJson(contenidoJson, tipo);
            System.out.println("✓ " + tipoObjeto + " cargados exitosamente desde: " + rutaArchivo);
            return resultado;
            
        } catch (IOException e) {
            System.err.println("✗ Error al cargar " + tipoObjeto + ": " + e.getMessage());
            return null;
        }
    }
    
    public boolean existenDatosGuardados() {
        File archivoLibros = new File(ARCHIVO_LIBROS);
        File archivoAutores = new File(ARCHIVO_AUTORES);
        return archivoLibros.exists() || archivoAutores.exists();
    }
    
    public void eliminarTodosDatos() {
        eliminarArchivo(ARCHIVO_LIBROS);
        eliminarArchivo(ARCHIVO_AUTORES);
        eliminarArchivo(ARCHIVO_ESTUDIANTES);
        eliminarArchivo(ARCHIVO_PRESTAMOS);
        System.out.println("✓ Todos los datos han sido eliminados");
    }
    
    private void eliminarArchivo(String ruta) {
        try {
            File archivo = new File(ruta);
            if (archivo.exists()) {
                archivo.delete();
            }
        } catch (Exception e) {
            System.err.println("✗ Error al eliminar archivo: " + e.getMessage());
        }
    }
    
    public void mostrarEstadoPersistencia() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   ESTADO DE PERSISTENCIA DE DATOS          ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("Directorio: " + DIRECTORIO_DATOS);
        System.out.println();
        verificarArchivo(ARCHIVO_LIBROS, "Libros");
        verificarArchivo(ARCHIVO_AUTORES, "Autores");
        verificarArchivo(ARCHIVO_ESTUDIANTES, "Estudiantes");
        verificarArchivo(ARCHIVO_PRESTAMOS, "Prestamos");
        System.out.println("════════════════════════════════════════════");
    }
    
    private void verificarArchivo(String ruta, String nombre) {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            long tamano = archivo.length();
            System.out.println("✓ " + nombre + ": " + tamano + " bytes");
        } else {
            System.out.println("✗ " + nombre + ": No existe");
        }
    }
}
        try {
            File directorio = new File(DIRECTORIO_DATOS);
            if (!directorio.exists()) {
                directorio.mkdirs();
                System.out.println("✓ Directorio de datos creado: " + DIRECTORIO_DATOS);
            }
        } catch (Exception e) {
            System.err.println("✗ Error al crear directorio: " + e.getMessage());
        }
    }
    
    // ==================== GUARDAR DATOS ====================
    
    /**
     * Guarda una lista de libros en formato JSON
     */
    public void guardarLibros(List<Libro> libros) {
        guardarJSON(libros, ARCHIVO_LIBROS, "Libros");
    }
    
    /**
     * Guarda una lista de autores en formato JSON
     */
    public void guardarAutores(List<Autor> autores) {
        guardarJSON(autores, ARCHIVO_AUTORES, "Autores");
    }
    
    /**
     * Guarda una lista de estudiantes en formato JSON
     */
    public void guardarEstudiantes(List<Estudiante> estudiantes) {
        guardarJSON(estudiantes, ARCHIVO_ESTUDIANTES, "Estudiantes");
    }
    
    /**
     * Guarda una lista de préstamos en formato JSON
     */
    public void guardarPrestamos(List<Prestamo> prestamos) {
        guardarJSON(prestamos, ARCHIVO_PRESTAMOS, "Préstamos");
    }
    
    /**
     * Método genérico para guardar objetos en JSON
     */
    private <T> void guardarJSON(T objeto, String rutaArchivo, String tipoObjeto) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);
            System.out.println("✓ " + tipoObjeto + " guardados exitosamente en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("✗ Error al guardar " + tipoObjeto + ": " + e.getMessage());
        }
    }
    
    // ==================== CARGAR DATOS ====================
    
    /**
     * Carga la lista de libros desde archivo JSON
     */
    public List<Libro> cargarLibros() {
        Type tipoLista = new TypeToken<ArrayList<Libro>>(){}.getType();
        return cargarJSON(ARCHIVO_LIBROS, tipoLista, "Libros");
    }
    
    /**
     * Carga la lista de autores desde archivo JSON
     */
    public List<Autor> cargarAutores() {
        Type tipoLista = new TypeToken<ArrayList<Autor>>(){}.getType();
        return cargarJSON(ARCHIVO_AUTORES, tipoLista, "Autores");
    }
    
    /**
     * Carga la lista de estudiantes desde archivo JSON
     */
    public List<Estudiante> cargarEstudiantes() {
        Type tipoLista = new TypeToken<ArrayList<Estudiante>>(){}.getType();
        return cargarJSON(ARCHIVO_ESTUDIANTES, tipoLista, "Estudiantes");
    }
    
    /**
     * Carga la lista de préstamos desde archivo JSON
     */
    public List<Prestamo> cargarPrestamos() {
        Type tipoLista = new TypeToken<ArrayList<Prestamo>>(){}.getType();
        return cargarJSON(ARCHIVO_PRESTAMOS, tipoLista, "Préstamos");
    }
    
    /**
     * Método genérico para cargar objetos desde JSON
     */
    private <T> T cargarJSON(String rutaArchivo, Type tipo, String tipoObjeto) {
        try {
            File archivo = new File(rutaArchivo);
            if (!archivo.exists()) {
                System.out.println("ℹ No se encontró archivo de " + tipoObjeto + ", creando nueva lista vacía");
                return null;
            }
            
            String contenidoJson = new String(Files.readAllBytes(Paths.get(rutaArchivo)));
            T resultado = gson.fromJson(contenidoJson, tipo);
            System.out.println("✓ " + tipoObjeto + " cargados exitosamente desde: " + rutaArchivo);
            return resultado;
            
        } catch (IOException e) {
            System.err.println("✗ Error al cargar " + tipoObjeto + ": " + e.getMessage());
            return null;
        }
    }
    
    // ==================== UTILIDADES ====================
    
    /**
     * Verifica si existen archivos de datos guardados
     */
    public boolean existenDatosGuardados() {
        File archivoLibros = new File(ARCHIVO_LIBROS);
        File archivoAutores = new File(ARCHIVO_AUTORES);
        return archivoLibros.exists() || archivoAutores.exists();
    }
    
    /**
     * Elimina todos los archivos de datos (reiniciar sistema)
     */
    public void eliminarTodosDatos() {
        eliminarArchivo(ARCHIVO_LIBROS);
        eliminarArchivo(ARCHIVO_AUTORES);
        eliminarArchivo(ARCHIVO_ESTUDIANTES);
        eliminarArchivo(ARCHIVO_PRESTAMOS);
        System.out.println("✓ Todos los datos han sido eliminados");
    }
    
    private void eliminarArchivo(String ruta) {
        try {
            File archivo = new File(ruta);
            if (archivo.exists()) {
                archivo.delete();
            }
        } catch (Exception e) {
            System.err.println("✗ Error al eliminar archivo: " + e.getMessage());
        }
    }
    
    /**
     * Muestra información sobre los archivos guardados
     */
    public void mostrarEstadoPersistencia() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   ESTADO DE PERSISTENCIA DE DATOS          ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("Directorio: " + DIRECTORIO_DATOS);
        System.out.println();
        verificarArchivo(ARCHIVO_LIBROS, "Libros");
        verificarArchivo(ARCHIVO_AUTORES, "Autores");
        verificarArchivo(ARCHIVO_ESTUDIANTES, "Estudiantes");
        verificarArchivo(ARCHIVO_PRESTAMOS, "Préstamos");
        System.out.println("════════════════════════════════════════════");
    }
    
    private void verificarArchivo(String ruta, String nombre) {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            long tamano = archivo.length();
            System.out.println("✓ " + nombre + ": " + tamano + " bytes");
        } else {
            System.out.println("✗ " + nombre + ": No existe");
        }
    }
}
