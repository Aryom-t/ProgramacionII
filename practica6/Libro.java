package com.mycompany.practica6;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String titulo;
    private String isbn;
    private List<Pagina> paginas;
    
    public Libro(String titulo, String isbn, String[] contenidoPaginas) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = new ArrayList<>();
        
        for (int i = 0; i < contenidoPaginas.length; i++) {
            paginas.add(new Pagina(i + 1, contenidoPaginas[i]));
        }
    }
    
    public void leer() {
        System.out.println("\n--- Leyendo: " + titulo + " ---");
        System.out.println("ISBN: " + isbn);
        System.out.println("Total de paginas: " + paginas.size());
        System.out.println();
        
        for (Pagina pagina : paginas) {
            pagina.mostrarPagina();
        }
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public int getNumeroPaginas() {
        return paginas.size();
    }
}
