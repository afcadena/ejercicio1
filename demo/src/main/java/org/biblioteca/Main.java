package org.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    
    public class GestionBiblioteca {
    
        public  void main(String[] args) {
            Biblioteca biblioteca = new Biblioteca();
            Scanner scanner = new Scanner(System.in);
    
            while (true) {
                System.out.println("\nMenú:");
                System.out.println("1. Agregar libro");
                System.out.println("2. Buscar libro por título");
                System.out.println("3. Buscar libro por autor");
                System.out.println("4. Mostrar todos los libros");
                System.out.println("5. Prestar libro");
                System.out.println("6. Devolver libro");
                System.out.println("Seleccione una opción:");
    
                String opcion = scanner.nextLine();
    
                switch (opcion) {
                    case "1" -> {
                        System.out.println("Título:");
                        String titulo = scanner.nextLine();
                        System.out.println("Autor:");
                        String autor = scanner.nextLine();
                        System.out.println("ISBN:");
                        String isbn = scanner.nextLine();
                        System.out.println("Año de publicación:");
                        int ano = Integer.parseInt(scanner.nextLine());
                        biblioteca.agregarLibro(titulo, autor, isbn, ano);
                    }
                    case "2" -> {
                        System.out.println("Título:");
                        String tituloBuscar = scanner.nextLine();
                        biblioteca.buscarLibroPorTitulo(tituloBuscar);
                    }
                    case "3" -> {
                        System.out.println("Autor:");
                        String autorBuscar = scanner.nextLine();
                        biblioteca.buscarLibroPorAutor(autorBuscar);
                    }
                    case "4" -> biblioteca.mostrarLibros();
                    case "5" -> {
                        System.out.println("Título:");
                        String tituloPrestar = scanner.nextLine();
                        biblioteca.prestarLibro(tituloPrestar);
                    }
                    case "6" -> {
                        System.out.println("Título:");
                        String tituloDevolver = scanner.nextLine();
                        biblioteca.devolverLibro(tituloDevolver);
                    }
                    case "7" -> {
                        System.out.println("Saliendo...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
            }
        }
    }
    
    class Biblioteca {
        private ArrayList<Libro> libros;
    
        public Biblioteca() {
            libros = new ArrayList<>();
        }
    
        public void agregarLibro(String titulo, String autor, String isbn, int ano) {
            libros.add(new Libro(titulo, autor, isbn, ano));
            System.out.println("Libro agregado.");
        }
    
        public void buscarLibroPorTitulo(String titulo) {
            boolean encontrado = false;
            for (Libro libro : libros) {
                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println(libro);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró el libro con ese título.");
            }
        }
    
        public void buscarLibroPorAutor(String autor) {
            boolean encontrado = false;
            for (Libro libro : libros) {
                if (libro.getAutor().equalsIgnoreCase(autor)) {
                    System.out.println(libro);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró el libro con ese autor.");
            }
        }
    
        public void mostrarLibros() {
            if (libros.isEmpty()) {
                System.out.println("No hay libros en la biblioteca.");
            } else {
                for (Libro libro : libros) {
                    System.out.println(libro);
                }
            }
        }
    
        public void prestarLibro(String titulo) {
            for (Libro libro : libros) {
                if (libro.getTitulo().equalsIgnoreCase(titulo) && !libro.isPrestado()) {
                    libro.setPrestado(true);
                    System.out.println("Libro prestado.");
                    return;
                }
            }
            System.out.println("No se pudo prestar el libro.");
        }
    
        public void devolverLibro(String titulo) {
            for (Libro libro : libros) {
                if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.isPrestado()) {
                    libro.setPrestado(false);
                    System.out.println("Libro devuelto.");
                    return;
                }
            }
            System.out.println("No se pudo devolver el libro.");
        }
    }
    
    class Libro {
        private String titulo;
        private String autor;
        private String isbn;
        private int ano;
        private boolean prestado;
    
        public Libro(String titulo, String autor, String isbn, int ano) {
            this.titulo = titulo;
            this.autor = autor;
            this.isbn = isbn;
            this.ano = ano;
            this.prestado = false;
        }

        public Libro() {
        }
    
        public String getTitulo() {
            return titulo;
        }
    
        public String getAutor() {
            return autor;
        }
    
        public boolean isPrestado() {
            return prestado;
        }
    
        public void setPrestado(boolean prestado) {
            this.prestado = prestado;
        }
    
        @Override
        public String toString() {
            return "Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + ", Año: " + ano + ", Prestado: " + (prestado ? "Sí" : "No");
        }
    }
}