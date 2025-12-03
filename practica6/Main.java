package com.mycompany.practica6;

/**
 * Clase principal para ejecutar el Sistema de Biblioteca con Persistencia
 * Práctica 6: Persistencia de Objetos con JSON usando Gson
 * 
 * @author ray-r
 */
public class Main {
    public static void main(String[] args) {
        // Iniciar el menú interactivo de la biblioteca
        MenuBiblioteca menu = new MenuBiblioteca();
        menu.iniciar();
    }
}