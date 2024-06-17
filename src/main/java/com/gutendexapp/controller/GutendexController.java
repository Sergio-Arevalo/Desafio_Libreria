package com.gutendexapp.controller;

import com.gutendexapp.model.Author;
import com.gutendexapp.model.Book;
import com.gutendexapp.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class GutendexController implements CommandLineRunner {

    @Autowired
    private GutendexService gutendexService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menú:");
            System.out.println("a. Buscar libro por título");
            System.out.println("b. Listar libros registrados");
            System.out.println("c. Listar autores registrados");
            System.out.println("d. Listar autores vivos en determinado año");
            System.out.println("e. Listar libros por idioma");
            System.out.println("f. Salir");
            String choice = scanner.nextLine();

            switch (choice) {
                case "a":
                    System.out.println("Ingrese el título del libro:");
                    String title = scanner.nextLine();
                    Book book = gutendexService.searchBookByTitle(title);
                    if (book != null) {
                        System.out.println("Título: " + book.getTitle());
                        System.out.println("Autor: " + book.getAuthor().getName());
                        System.out.println("Idioma: " + book.getLanguage());
                        System.out.println("Número de descargas: " + book.getDownloadCount());
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;
                case "b":
                    List<Book> books = gutendexService.getAllBooks();
                    books.forEach(b -> {
                        System.out.println("Título: " + b.getTitle());
                        System.out.println("Autor: " + b.getAuthor().getName());
                        System.out.println("Idioma: " + b.getLanguage());
                        System.out.println("Número de descargas: " + b.getDownloadCount());
                    });
                    break;
                case "c":
                    List<Author> authors = gutendexService.getAllAuthors();
                    authors.forEach(a -> {
                        System.out.println("Nombre: " + a.getName());
                        System.out.println("Fecha de nacimiento: " + a.getBirthDate());
                        System.out.println("Fecha de muerte: " + a.getDeathDate());
                        System.out.println("Títulos: " + a.getBooks().stream().map(Book::getTitle).toList());
                    });
                    break;
                case "d":
                    System.out.println("Ingrese el año:");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    List<Author> authorsAlive = gutendexService.getAuthorsAliveInYear(year);
                    authorsAlive.forEach(a -> {
                        System.out.println("Nombre: " + a.getName());
                        System.out.println("Fecha de nacimiento: " + a.getBirthDate());
                        System.out.println("Fecha de muerte: " + a.getDeathDate());
                        System.out.println("Títulos: " + a.getBooks().stream().map(Book::getTitle).toList());
                    });
                    break;
                case "e":
                    System.out.println("Seleccione el idioma (Es-español, En-inglés, Fr-francés, Pt-portugués):");
                    String language = scanner.nextLine();
                    List<Book> booksByLanguage = gutendexService.getBooksByLanguage(language);
                    booksByLanguage.forEach(b -> {
                        System.out.println("Título: " + b.getTitle());
                        System.out.println("Autor: " + b.getAuthor().getName());
                        System.out.println("Idioma: " + b.getLanguage());
                        System.out.println("Número de descargas: " + b.getDownloadCount());
                    });
                    break;
                case "f":
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
