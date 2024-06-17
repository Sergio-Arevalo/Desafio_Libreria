package com.gutendexapp.service;

import com.gutendexapp.dto.GutendexResponse;
import com.gutendexapp.model.Author;
import com.gutendexapp.model.Book;
import com.gutendexapp.repository.AuthorRepository;
import com.gutendexapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GutendexService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String GUTENDEX_API_URL = "https://gutendex.com/books?search=";

    public Book searchBookByTitle(String title) {
        Optional<Book> existingBook = bookRepository.findAll()
                .stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst();
        if (existingBook.isPresent()) {
            return existingBook.get();
        }

        String url = GUTENDEX_API_URL + title;
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);

        if (response != null && !response.getResults().isEmpty()) {
            GutendexResponse.BookDto bookDto = response.getResults().get(0);

            GutendexResponse.BookDto.AuthorDto authorDto = bookDto.getAuthors().get(0);
            Author author = authorRepository.findAll()
                    .stream()
                    .filter(a -> a.getName().equalsIgnoreCase(authorDto.getName()))
                    .findFirst()
                    .orElseGet(() -> {
                        Author newAuthor = new Author();
                        newAuthor.setName(authorDto.getName());
                        authorRepository.save(newAuthor);
                        return newAuthor;
                    });

            Book newBook = new Book();
            newBook.setTitle(bookDto.getTitle());
            newBook.setAuthor(author);
            newBook.setLanguage(bookDto.getLanguages().get(0));
            newBook.setDownloadCount(bookDto.getDownloadCount());
            bookRepository.save(newBook);

            return newBook;
        }

        return null;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getAuthorsAliveInYear(int year) {
        return authorRepository.findAll().stream()
                .filter(author -> author.getBirthDate() <= year && (author.getDeathDate() == null || author.getDeathDate() >= year))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByLanguage(String language) {
        return bookRepository.findAll().stream()
                .filter(book -> book.getLanguage().equalsIgnoreCase(language))
                .collect(Collectors.toList());
    }
}
