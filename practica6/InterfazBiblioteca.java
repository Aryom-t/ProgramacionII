package com.mycompany.practica6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 * Interfaz Gráfica para el Sistema de Biblioteca UMSA
 * Práctica 6: Persistencia de Objetos con JSON
 */
public class InterfazBiblioteca extends JFrame {
    
    private Biblioteca biblioteca;
    
    // Componentes de la interfaz
    private JTabbedPane tabbedPane;
    
    // Panel de Libros
    private JTextField txtTituloLibro, txtIsbnLibro;
    private JTextArea txtContenidoLibro;
    private JTable tablaLibros;
    private DefaultTableModel modeloLibros;
    
    // Panel de Autores
    private JTextField txtNombreAutor, txtNacionalidadAutor;
    private JTable tablaAutores;
    private DefaultTableModel modeloAutores;
    
    // Panel de Estudiantes
    private JTextField txtCodigoEstudiante, txtNombreEstudiante;
    private JTable tablaEstudiantes;
    private DefaultTableModel modeloEstudiantes;
    
    // Panel de Préstamos
    private JComboBox<String> comboEstudiantes, comboLibros;
    private JTable tablaPrestamos;
    private DefaultTableModel modeloPrestamos;
    
    public InterfazBiblioteca() {
        biblioteca = new Biblioteca("Biblioteca Central UMSA");
        initComponents();
        setLocationRelativeTo(null);
        
        // Cargar datos al iniciar
        if (biblioteca.existenDatosGuardados()) {
            int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Desea cargar los datos guardados anteriormente?",
                "Cargar Datos",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                cargarDatos();
            } else {
                // Si no carga, agregar datos de ejemplo
                cargarDatosEjemplo();
            }
        } else {
            // Si no hay datos guardados, cargar ejemplos
            cargarDatosEjemplo();
        }
    }
    
    /**
     * Carga datos de ejemplo en el sistema
     */
    private void cargarDatosEjemplo() {
        // LIBROS DE EJEMPLO
        String[] paginasJava = {
            "Capítulo 1: Introducción a Java",
            "Java es un lenguaje de programación orientado a objetos",
            "Capítulo 2: Variables y Tipos de Datos",
            "Los tipos primitivos en Java incluyen int, double, boolean",
            "Capítulo 3: Programación Orientada a Objetos",
            "Las clases son plantillas para crear objetos"
        };
        Libro libro1 = new Libro("Programación en Java", "101", paginasJava);
        biblioteca.agregarLibro(libro1);
        modeloLibros.addRow(new Object[]{libro1.getTitulo(), libro1.getIsbn(), libro1.getNumeroPaginas()});
        
        String[] paginasEstructuras = {
            "Capítulo 1: Listas Enlazadas",
            "Una lista enlazada es una estructura de datos lineal",
            "Capítulo 2: Pilas y Colas",
            "LIFO - Last In First Out para pilas",
            "Capítulo 3: Árboles Binarios",
            "Los árboles binarios tienen máximo 2 hijos por nodo"
        };
        Libro libro2 = new Libro("Estructuras de Datos", "102", paginasEstructuras);
        biblioteca.agregarLibro(libro2);
        modeloLibros.addRow(new Object[]{libro2.getTitulo(), libro2.getIsbn(), libro2.getNumeroPaginas()});
        
        String[] paginasAlgoritmos = {
            "Capítulo 1: Análisis de Algoritmos",
            "Big O notation mide la eficiencia de algoritmos",
            "Capítulo 2: Algoritmos de Ordenamiento",
            "QuickSort, MergeSort, BubbleSort",
            "Capítulo 3: Recursividad",
            "Un algoritmo recursivo se llama a sí mismo"
        };
        Libro libro3 = new Libro("Algoritmos y Complejidad", "103", paginasAlgoritmos);
        biblioteca.agregarLibro(libro3);
        modeloLibros.addRow(new Object[]{libro3.getTitulo(), libro3.getIsbn(), libro3.getNumeroPaginas()});
        
        String[] paginasBaseDatos = {
            "Capítulo 1: Modelo Relacional",
            "Las bases de datos relacionales usan tablas",
            "Capítulo 2: SQL - Structured Query Language",
            "SELECT, INSERT, UPDATE, DELETE",
            "Capítulo 3: Normalización",
            "Primera, segunda y tercera forma normal"
        };
        Libro libro4 = new Libro("Fundamentos de Bases de Datos", "104", paginasBaseDatos);
        biblioteca.agregarLibro(libro4);
        modeloLibros.addRow(new Object[]{libro4.getTitulo(), libro4.getIsbn(), libro4.getNumeroPaginas()});
        
        String[] paginasWeb = {
            "Capítulo 1: HTML y CSS",
            "HTML estructura el contenido web",
            "Capítulo 2: JavaScript",
            "JavaScript añade interactividad",
            "Capítulo 3: Frameworks Modernos",
            "React, Vue, Angular son frameworks populares"
        };
        Libro libro5 = new Libro("Desarrollo Web Moderno", "105", paginasWeb);
        biblioteca.agregarLibro(libro5);
        modeloLibros.addRow(new Object[]{libro5.getTitulo(), libro5.getIsbn(), libro5.getNumeroPaginas()});
        
        // AUTORES DE EJEMPLO
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiano");
        biblioteca.agregarAutor(autor1);
        modeloAutores.addRow(new Object[]{autor1.getNombre(), autor1.getNacionalidad()});
        
        Autor autor2 = new Autor("Mario Vargas Llosa", "Peruano");
        biblioteca.agregarAutor(autor2);
        modeloAutores.addRow(new Object[]{autor2.getNombre(), autor2.getNacionalidad()});
        
        Autor autor3 = new Autor("Isabel Allende", "Chilena");
        biblioteca.agregarAutor(autor3);
        modeloAutores.addRow(new Object[]{autor3.getNombre(), autor3.getNacionalidad()});
        
        Autor autor4 = new Autor("Jorge Luis Borges", "Argentino");
        biblioteca.agregarAutor(autor4);
        modeloAutores.addRow(new Object[]{autor4.getNombre(), autor4.getNacionalidad()});
        
        Autor autor5 = new Autor("Octavio Paz", "Mexicano");
        biblioteca.agregarAutor(autor5);
        modeloAutores.addRow(new Object[]{autor5.getNombre(), autor5.getNacionalidad()});
        
        // ESTUDIANTES DE EJEMPLO
        Estudiante est1 = new Estudiante("1001", "Juan Pérez Mamani");
        biblioteca.agregarEstudiante(est1);
        modeloEstudiantes.addRow(new Object[]{est1.getCodigoEstudiante(), est1.getNombre()});
        
        Estudiante est2 = new Estudiante("1002", "María Rodríguez Quispe");
        biblioteca.agregarEstudiante(est2);
        modeloEstudiantes.addRow(new Object[]{est2.getCodigoEstudiante(), est2.getNombre()});
        
        Estudiante est3 = new Estudiante("1003", "Carlos López Condori");
        biblioteca.agregarEstudiante(est3);
        modeloEstudiantes.addRow(new Object[]{est3.getCodigoEstudiante(), est3.getNombre()});
        
        Estudiante est4 = new Estudiante("1004", "Ana Flores Huanca");
        biblioteca.agregarEstudiante(est4);
        modeloEstudiantes.addRow(new Object[]{est4.getCodigoEstudiante(), est4.getNombre()});
        
        Estudiante est5 = new Estudiante("1005", "Luis Torrez Apaza");
        biblioteca.agregarEstudiante(est5);
        modeloEstudiantes.addRow(new Object[]{est5.getCodigoEstudiante(), est5.getNombre()});
        
        // PRÉSTAMOS DE EJEMPLO
        biblioteca.prestarLibro(est1, libro1);
        Prestamo p1 = biblioteca.getPrestamosActivos().get(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        modeloPrestamos.addRow(new Object[]{
            est1.getNombre(),
            libro1.getTitulo(),
            p1.getFechaPrestamo().format(formatter),
            p1.getFechaDevolucion().format(formatter)
        });
        
        biblioteca.prestarLibro(est2, libro2);
        Prestamo p2 = biblioteca.getPrestamosActivos().get(1);
        modeloPrestamos.addRow(new Object[]{
            est2.getNombre(),
            libro2.getTitulo(),
            p2.getFechaPrestamo().format(formatter),
            p2.getFechaDevolucion().format(formatter)
        });
        
        biblioteca.prestarLibro(est3, libro4);
        Prestamo p3 = biblioteca.getPrestamosActivos().get(2);
        modeloPrestamos.addRow(new Object[]{
            est3.getNombre(),
            libro4.getTitulo(),
            p3.getFechaPrestamo().format(formatter),
            p3.getFechaDevolucion().format(formatter)
        });
        
        // Actualizar combos
        actualizarComboEstudiantes();
        actualizarComboLibros();
    }
    
    private void initComponents() {
        setTitle("📚 Sistema de Biblioteca UMSA - Práctica 6: Persistencia con JSON");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 700);
        setResizable(false);
        
        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel de título
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 102, 153));
        headerPanel.setPreferredSize(new Dimension(0, 70));
        JLabel titleLabel = new JLabel("📚 SISTEMA DE BIBLIOTECA UMSA");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        
        // Pestañas
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        tabbedPane.addTab("📚 Libros", crearPanelLibros());
        tabbedPane.addTab("✍️ Autores", crearPanelAutores());
        tabbedPane.addTab("👤 Estudiantes", crearPanelEstudiantes());
        tabbedPane.addTab("📋 Préstamos", crearPanelPrestamos());
        tabbedPane.addTab("📊 Estado", crearPanelEstado());
        
        // Panel de botones inferiores
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        botonesPanel.setBackground(Color.WHITE);
        
        JButton btnGuardar = crearBoton("💾 GUARDAR DATOS", new Color(0, 204, 102));
        JButton btnCargar = crearBoton("📂 CARGAR DATOS", new Color(0, 153, 204));
        JButton btnSalir = crearBoton("🚪 SALIR", new Color(204, 51, 51));
        
        btnGuardar.addActionListener(e -> guardarDatos());
        btnCargar.addActionListener(e -> cargarDatos());
        btnSalir.addActionListener(e -> salir());
        
        botonesPanel.add(btnGuardar);
        botonesPanel.add(btnCargar);
        botonesPanel.add(btnSalir);
        
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        mainPanel.add(botonesPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    // ==================== PANEL DE LIBROS ====================
    
    private JPanel crearPanelLibros() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel de formulario
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        formPanel.add(new JLabel("Título del Libro:"), gbc);
        
        gbc.gridy = 1;
        txtTituloLibro = new JTextField(30);
        formPanel.add(txtTituloLibro, gbc);
        
        gbc.gridy = 2; gbc.gridwidth = 1;
        formPanel.add(new JLabel("ISBN (3 dígitos):"), gbc);
        
        gbc.gridy = 3; gbc.gridwidth = 2;
        txtIsbnLibro = new JTextField(30);
        formPanel.add(txtIsbnLibro, gbc);
        
        gbc.gridy = 4;
        formPanel.add(new JLabel("Contenido (una línea por página):"), gbc);
        
        gbc.gridy = 5; gbc.weighty = 1;
        txtContenidoLibro = new JTextArea(4, 30);
        txtContenidoLibro.setLineWrap(true);
        JScrollPane scrollContenido = new JScrollPane(txtContenidoLibro);
        formPanel.add(scrollContenido, gbc);
        
        // Botones
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botonesPanel.setBackground(Color.WHITE);
        
        JButton btnAgregar = crearBoton("➕ Agregar Libro", new Color(0, 153, 76));
        JButton btnLimpiar = crearBoton("🧹 Limpiar", new Color(102, 102, 102));
        JButton btnEliminar = crearBoton("🗑️ Eliminar", new Color(204, 0, 0));
        
        btnAgregar.addActionListener(e -> agregarLibro());
        btnLimpiar.addActionListener(e -> limpiarFormularioLibro());
        btnEliminar.addActionListener(e -> eliminarLibro());
        
        botonesPanel.add(btnAgregar);
        botonesPanel.add(btnLimpiar);
        botonesPanel.add(btnEliminar);
        
        gbc.gridy = 6; gbc.weighty = 0;
        formPanel.add(botonesPanel, gbc);
        
        // Tabla
        String[] columnasLibros = {"Título", "ISBN", "Páginas"};
        modeloLibros = new DefaultTableModel(columnasLibros, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaLibros = new JTable(modeloLibros);
        JScrollPane scrollTabla = new JScrollPane(tablaLibros);
        
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(scrollTabla, BorderLayout.CENTER);
        
        return panel;
    }
    
    // ==================== PANEL DE AUTORES ====================
    
    private JPanel crearPanelAutores() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        formPanel.add(new JLabel("Nombre del Autor:"), gbc);
        
        gbc.gridy = 1;
        txtNombreAutor = new JTextField(30);
        formPanel.add(txtNombreAutor, gbc);
        
        gbc.gridy = 2;
        formPanel.add(new JLabel("Nacionalidad:"), gbc);
        
        gbc.gridy = 3;
        txtNacionalidadAutor = new JTextField(30);
        formPanel.add(txtNacionalidadAutor, gbc);
        
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botonesPanel.setBackground(Color.WHITE);
        
        JButton btnAgregar = crearBoton("➕ Agregar Autor", new Color(0, 153, 76));
        JButton btnLimpiar = crearBoton("🧹 Limpiar", new Color(102, 102, 102));
        JButton btnEliminar = crearBoton("🗑️ Eliminar", new Color(204, 0, 0));
        
        btnAgregar.addActionListener(e -> agregarAutor());
        btnLimpiar.addActionListener(e -> limpiarFormularioAutor());
        btnEliminar.addActionListener(e -> eliminarAutor());
        
        botonesPanel.add(btnAgregar);
        botonesPanel.add(btnLimpiar);
        botonesPanel.add(btnEliminar);
        
        gbc.gridy = 4;
        formPanel.add(botonesPanel, gbc);
        
        String[] columnasAutores = {"Nombre", "Nacionalidad"};
        modeloAutores = new DefaultTableModel(columnasAutores, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaAutores = new JTable(modeloAutores);
        JScrollPane scrollTabla = new JScrollPane(tablaAutores);
        
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(scrollTabla, BorderLayout.CENTER);
        
        return panel;
    }
    
    // ==================== PANEL DE ESTUDIANTES ====================
    
    private JPanel crearPanelEstudiantes() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        formPanel.add(new JLabel("Código de Estudiante:"), gbc);
        
        gbc.gridy = 1;
        txtCodigoEstudiante = new JTextField(30);
        formPanel.add(txtCodigoEstudiante, gbc);
        
        gbc.gridy = 2;
        formPanel.add(new JLabel("Nombre del Estudiante:"), gbc);
        
        gbc.gridy = 3;
        txtNombreEstudiante = new JTextField(30);
        formPanel.add(txtNombreEstudiante, gbc);
        
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botonesPanel.setBackground(Color.WHITE);
        
        JButton btnAgregar = crearBoton("➕ Agregar Estudiante", new Color(0, 153, 76));
        JButton btnLimpiar = crearBoton("🧹 Limpiar", new Color(102, 102, 102));
        JButton btnEliminar = crearBoton("🗑️ Eliminar", new Color(204, 0, 0));
        
        btnAgregar.addActionListener(e -> agregarEstudiante());
        btnLimpiar.addActionListener(e -> limpiarFormularioEstudiante());
        btnEliminar.addActionListener(e -> eliminarEstudiante());
        
        botonesPanel.add(btnAgregar);
        botonesPanel.add(btnLimpiar);
        botonesPanel.add(btnEliminar);
        
        gbc.gridy = 4;
        formPanel.add(botonesPanel, gbc);
        
        String[] columnasEstudiantes = {"Código", "Nombre"};
        modeloEstudiantes = new DefaultTableModel(columnasEstudiantes, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaEstudiantes = new JTable(modeloEstudiantes);
        JScrollPane scrollTabla = new JScrollPane(tablaEstudiantes);
        
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(scrollTabla, BorderLayout.CENTER);
        
        return panel;
    }
    
    // ==================== PANEL DE PRÉSTAMOS ====================
    
    private JPanel crearPanelPrestamos() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        formPanel.add(new JLabel("Seleccionar Estudiante:"), gbc);
        
        gbc.gridy = 1;
        comboEstudiantes = new JComboBox<>();
        formPanel.add(comboEstudiantes, gbc);
        
        gbc.gridy = 2;
        formPanel.add(new JLabel("Seleccionar Libro:"), gbc);
        
        gbc.gridy = 3;
        comboLibros = new JComboBox<>();
        formPanel.add(comboLibros, gbc);
        
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botonesPanel.setBackground(Color.WHITE);
        
        JButton btnRealizar = crearBoton("📝 Realizar Préstamo", new Color(0, 153, 76));
        JButton btnEliminar = crearBoton("🗑️ Eliminar Préstamo", new Color(204, 0, 0));
        
        btnRealizar.addActionListener(e -> realizarPrestamo());
        btnEliminar.addActionListener(e -> eliminarPrestamo());
        
        botonesPanel.add(btnRealizar);
        botonesPanel.add(btnEliminar);
        
        gbc.gridy = 4;
        formPanel.add(botonesPanel, gbc);
        
        String[] columnasPrestamos = {"Estudiante", "Libro", "Fecha Préstamo", "Fecha Devolución"};
        modeloPrestamos = new DefaultTableModel(columnasPrestamos, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaPrestamos = new JTable(modeloPrestamos);
        JScrollPane scrollTabla = new JScrollPane(tablaPrestamos);
        
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(scrollTabla, BorderLayout.CENTER);
        
        return panel;
    }
    
    // ==================== PANEL DE ESTADO ====================
    
    private JPanel crearPanelEstado() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JTextArea txtEstado = new JTextArea();
        txtEstado.setEditable(false);
        txtEstado.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtEstado.setBackground(new Color(245, 245, 245));
        
        JScrollPane scrollEstado = new JScrollPane(txtEstado);
        
        JButton btnActualizar = crearBoton("🔄 Actualizar Estado", new Color(0, 102, 204));
        btnActualizar.addActionListener(e -> {
            StringBuilder estado = new StringBuilder();
            estado.append("════════════════════════════════════════════════════════════════\n");
            estado.append("              ESTADO DE LA BIBLIOTECA: ").append(biblioteca.getNombre()).append("\n");
            estado.append("════════════════════════════════════════════════════════════════\n\n");
            
            // HORARIO (COMPOSICIÓN)
            estado.append("📅 HORARIO DE ATENCIÓN (Composición)\n");
            estado.append("─────────────────────────────────────\n");
            Horario horario = biblioteca.getHorario();
            estado.append("  Días: ").append(horario.getDiasApertura()).append("\n");
            estado.append("  Horario: ").append(horario.getHoraApertura()).append(" - ").append(horario.getHoraCierre()).append("\n\n");
            
            // LIBROS (AGREGACIÓN)
            estado.append("📚 LIBROS DISPONIBLES (Agregación) - Total: ").append(biblioteca.getLibros().size()).append("\n");
            estado.append("─────────────────────────────────────\n");
            if (biblioteca.getLibros().isEmpty()) {
                estado.append("  (No hay libros registrados)\n\n");
            } else {
                for (int i = 0; i < biblioteca.getLibros().size(); i++) {
                    Libro libro = biblioteca.getLibros().get(i);
                    estado.append("  ").append(i + 1).append(". ").append(libro.getTitulo()).append("\n");
                    estado.append("     ISBN: ").append(libro.getIsbn()).append("\n");
                    estado.append("     Páginas: ").append(libro.getNumeroPaginas()).append(" (Composición)\n");
                }
                estado.append("\n");
            }
            
            // AUTORES (AGREGACIÓN)
            estado.append("✍️ AUTORES REGISTRADOS (Agregación) - Total: ").append(biblioteca.getAutores().size()).append("\n");
            estado.append("─────────────────────────────────────\n");
            if (biblioteca.getAutores().isEmpty()) {
                estado.append("  (No hay autores registrados)\n\n");
            } else {
                for (int i = 0; i < biblioteca.getAutores().size(); i++) {
                    Autor autor = biblioteca.getAutores().get(i);
                    estado.append("  ").append(i + 1).append(". ").append(autor.getNombre());
                    estado.append(" (").append(autor.getNacionalidad()).append(")\n");
                }
                estado.append("\n");
            }
            
            // ESTUDIANTES
            estado.append("👤 ESTUDIANTES REGISTRADOS - Total: ").append(biblioteca.getEstudiantes().size()).append("\n");
            estado.append("─────────────────────────────────────\n");
            if (biblioteca.getEstudiantes().isEmpty()) {
                estado.append("  (No hay estudiantes registrados)\n\n");
            } else {
                for (int i = 0; i < biblioteca.getEstudiantes().size(); i++) {
                    Estudiante est = biblioteca.getEstudiantes().get(i);
                    estado.append("  ").append(i + 1).append(". ").append(est.getNombre());
                    estado.append(" - Código: ").append(est.getCodigoEstudiante()).append("\n");
                }
                estado.append("\n");
            }
            
            // PRÉSTAMOS ACTIVOS (COMPOSICIÓN)
            estado.append("📋 PRÉSTAMOS ACTIVOS (Composición) - Total: ").append(biblioteca.getPrestamosActivos().size()).append("\n");
            estado.append("─────────────────────────────────────\n");
            if (biblioteca.getPrestamosActivos().isEmpty()) {
                estado.append("  (No hay préstamos activos)\n\n");
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                for (int i = 0; i < biblioteca.getPrestamosActivos().size(); i++) {
                    Prestamo p = biblioteca.getPrestamosActivos().get(i);
                    estado.append("  ").append(i + 1).append(". ").append(p.getEstudiante().getNombre());
                    estado.append(" → ").append(p.getLibro().getTitulo()).append("\n");
                    estado.append("     Préstamo: ").append(p.getFechaPrestamo().format(formatter));
                    estado.append(" | Devolución: ").append(p.getFechaDevolucion().format(formatter)).append("\n");
                }
                estado.append("\n");
            }
            
            estado.append("════════════════════════════════════════════════════════════════\n");
            estado.append("RELACIONES UML:\n");
            estado.append("  ◆ COMPOSICIÓN (dependencia fuerte):\n");
            estado.append("    - Biblioteca contiene Horario\n");
            estado.append("    - Biblioteca contiene Préstamos\n");
            estado.append("    - Libro contiene Páginas\n\n");
            estado.append("  ◇ AGREGACIÓN (dependencia débil):\n");
            estado.append("    - Biblioteca referencia Libros\n");
            estado.append("    - Biblioteca referencia Autores\n\n");
            estado.append("  → ASOCIACIÓN (relación simple):\n");
            estado.append("    - Préstamo referencia Estudiante\n");
            estado.append("    - Préstamo referencia Libro\n");
            estado.append("════════════════════════════════════════════════════════════════\n");
            
            txtEstado.setText(estado.toString());
            txtEstado.setCaretPosition(0);
        });
        
        JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botonPanel.setBackground(Color.WHITE);
        botonPanel.add(btnActualizar);
        
        JButton btnCerrarBiblioteca = crearBoton("🔒 Cerrar Biblioteca", new Color(204, 51, 0));
        btnCerrarBiblioteca.addActionListener(e -> {
            int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de cerrar la biblioteca?\nEsto eliminará todos los préstamos activos (COMPOSICIÓN)\nLos libros y autores se mantendrán (AGREGACIÓN)",
                "Cerrar Biblioteca",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                biblioteca.cerrarBiblioteca();
                modeloPrestamos.setRowCount(0);
                JOptionPane.showMessageDialog(this, 
                    "Biblioteca cerrada.\n" +
                    "- Préstamos eliminados (COMPOSICIÓN)\n" +
                    "- Libros y Autores conservados (AGREGACIÓN)", 
                    "Biblioteca Cerrada", 
                    JOptionPane.INFORMATION_MESSAGE);
                btnActualizar.doClick(); // Actualizar estado
            }
        });
        botonPanel.add(btnCerrarBiblioteca);
        
        panel.add(scrollEstado, BorderLayout.CENTER);
        panel.add(botonPanel, BorderLayout.SOUTH);
        
        // Mostrar estado inicial
        btnActualizar.doClick();
        
        return panel;
    }
    
    // ==================== MÉTODOS DE LIBROS ====================
    
    private void agregarLibro() {
        String titulo = txtTituloLibro.getText().trim();
        String isbn = txtIsbnLibro.getText().trim();
        String contenido = txtContenidoLibro.getText().trim();
        
        if (titulo.isEmpty() || isbn.isEmpty() || contenido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String[] paginas = contenido.split("\n");
        Libro libro = new Libro(titulo, isbn, paginas);
        biblioteca.agregarLibro(libro);
        
        modeloLibros.addRow(new Object[]{titulo, isbn, paginas.length});
        actualizarComboLibros();
        limpiarFormularioLibro();
        
        JOptionPane.showMessageDialog(this, "Libro agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void limpiarFormularioLibro() {
        txtTituloLibro.setText("");
        txtIsbnLibro.setText("");
        txtContenidoLibro.setText("");
    }
    
    private void eliminarLibro() {
        int selectedRow = tablaLibros.getSelectedRow();
        if (selectedRow >= 0) {
            biblioteca.getLibros().remove(selectedRow);
            modeloLibros.removeRow(selectedRow);
            actualizarComboLibros();
            JOptionPane.showMessageDialog(this, "Libro eliminado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un libro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // ==================== MÉTODOS DE AUTORES ====================
    
    private void agregarAutor() {
        String nombre = txtNombreAutor.getText().trim();
        String nacionalidad = txtNacionalidadAutor.getText().trim();
        
        if (nombre.isEmpty() || nacionalidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Autor autor = new Autor(nombre, nacionalidad);
        biblioteca.agregarAutor(autor);
        
        modeloAutores.addRow(new Object[]{nombre, nacionalidad});
        limpiarFormularioAutor();
        
        JOptionPane.showMessageDialog(this, "Autor agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void limpiarFormularioAutor() {
        txtNombreAutor.setText("");
        txtNacionalidadAutor.setText("");
    }
    
    private void eliminarAutor() {
        int selectedRow = tablaAutores.getSelectedRow();
        if (selectedRow >= 0) {
            biblioteca.getAutores().remove(selectedRow);
            modeloAutores.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Autor eliminado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un autor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // ==================== MÉTODOS DE ESTUDIANTES ====================
    
    private void agregarEstudiante() {
        String codigo = txtCodigoEstudiante.getText().trim();
        String nombre = txtNombreEstudiante.getText().trim();
        
        if (codigo.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Estudiante estudiante = new Estudiante(codigo, nombre);
        biblioteca.agregarEstudiante(estudiante);
        
        modeloEstudiantes.addRow(new Object[]{codigo, nombre});
        actualizarComboEstudiantes();
        limpiarFormularioEstudiante();
        
        JOptionPane.showMessageDialog(this, "Estudiante agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void limpiarFormularioEstudiante() {
        txtCodigoEstudiante.setText("");
        txtNombreEstudiante.setText("");
    }
    
    private void eliminarEstudiante() {
        int selectedRow = tablaEstudiantes.getSelectedRow();
        if (selectedRow >= 0) {
            biblioteca.getEstudiantes().remove(selectedRow);
            modeloEstudiantes.removeRow(selectedRow);
            actualizarComboEstudiantes();
            JOptionPane.showMessageDialog(this, "Estudiante eliminado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un estudiante", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // ==================== MÉTODOS DE PRÉSTAMOS ====================
    
    private void realizarPrestamo() {
        int indiceEstudiante = comboEstudiantes.getSelectedIndex();
        int indiceLibro = comboLibros.getSelectedIndex();
        
        if (indiceEstudiante < 0 || indiceLibro < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un estudiante y un libro", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Estudiante estudiante = biblioteca.getEstudiantes().get(indiceEstudiante);
        Libro libro = biblioteca.getLibros().get(indiceLibro);
        
        biblioteca.prestarLibro(estudiante, libro);
        
        Prestamo prestamo = biblioteca.getPrestamosActivos().get(biblioteca.getPrestamosActivos().size() - 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        modeloPrestamos.addRow(new Object[]{
            estudiante.getNombre(),
            libro.getTitulo(),
            prestamo.getFechaPrestamo().format(formatter),
            prestamo.getFechaDevolucion().format(formatter)
        });
        
        JOptionPane.showMessageDialog(this, "Préstamo realizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void eliminarPrestamo() {
        int selectedRow = tablaPrestamos.getSelectedRow();
        if (selectedRow >= 0) {
            biblioteca.getPrestamosActivos().remove(selectedRow);
            modeloPrestamos.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Préstamo eliminado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un préstamo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // ==================== MÉTODOS DE PERSISTENCIA ====================
    
    private void guardarDatos() {
        biblioteca.guardarDatos();
        JOptionPane.showMessageDialog(this, 
            "Todos los datos han sido guardados exitosamente en archivos JSON", 
            "Datos Guardados", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void cargarDatos() {
        biblioteca.cargarDatos();
        actualizarTodasLasTablas();
        JOptionPane.showMessageDialog(this, 
            "Datos cargados exitosamente desde archivos JSON", 
            "Datos Cargados", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void actualizarTodasLasTablas() {
        // Limpiar tablas
        modeloLibros.setRowCount(0);
        modeloAutores.setRowCount(0);
        modeloEstudiantes.setRowCount(0);
        modeloPrestamos.setRowCount(0);
        
        // Actualizar libros
        for (Libro libro : biblioteca.getLibros()) {
            modeloLibros.addRow(new Object[]{
                libro.getTitulo(),
                libro.getIsbn(),
                libro.getNumeroPaginas()
            });
        }
        
        // Actualizar autores
        for (Autor autor : biblioteca.getAutores()) {
            modeloAutores.addRow(new Object[]{
                autor.getNombre(),
                autor.getNacionalidad()
            });
        }
        
        // Actualizar estudiantes
        for (Estudiante est : biblioteca.getEstudiantes()) {
            modeloEstudiantes.addRow(new Object[]{
                est.getCodigoEstudiante(),
                est.getNombre()
            });
        }
        
        // Actualizar préstamos
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Prestamo prestamo : biblioteca.getPrestamosActivos()) {
            modeloPrestamos.addRow(new Object[]{
                prestamo.getEstudiante().getNombre(),
                prestamo.getLibro().getTitulo(),
                prestamo.getFechaPrestamo().format(formatter),
                prestamo.getFechaDevolucion().format(formatter)
            });
        }
        
        actualizarComboEstudiantes();
        actualizarComboLibros();
    }
    
    private void actualizarComboEstudiantes() {
        comboEstudiantes.removeAllItems();
        for (Estudiante est : biblioteca.getEstudiantes()) {
            comboEstudiantes.addItem(est.getNombre());
        }
    }
    
    private void actualizarComboLibros() {
        comboLibros.removeAllItems();
        for (Libro libro : biblioteca.getLibros()) {
            comboLibros.addItem(libro.getTitulo());
        }
    }
    
    private void salir() {
        int respuesta = JOptionPane.showConfirmDialog(
            this,
            "¿Desea guardar los datos antes de salir?",
            "Confirmar Salida",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        if (respuesta == JOptionPane.YES_OPTION) {
            guardarDatos();
            System.exit(0);
        } else if (respuesta == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
    }
    
    // ==================== MÉTODO AUXILIAR ====================
    
    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setPreferredSize(new Dimension(170, 35));
        return boton;
    }
    
    // ==================== MAIN ====================
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            InterfazBiblioteca frame = new InterfazBiblioteca();
            frame.setVisible(true);
        });
    }
}
