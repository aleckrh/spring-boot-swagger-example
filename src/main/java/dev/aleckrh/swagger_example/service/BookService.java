package dev.aleckrh.swagger_example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.aleckrh.swagger_example.model.Book;

@Service
public class BookService {
    List<Book> books = new ArrayList<>();
    static long id = 0;

    public BookService() {
        List<Book> _books = new ArrayList<>();
        _books.add(new Book(0, "The Moon", "John Doe", true));
        _books.add(new Book(0, "The Sun", "Jane Doe", false));
        _books.add(new Book(0, "The Earth", "John Smith", true));
        _books.add(new Book(0, "The Mars", "Jane Smith", false));
        _books.add(new Book(0, "The Venus", "John Doe", true));
        _books.add(new Book(0, "The Jupiter", "Jane Doe", false));
        _books.add(new Book(0, "The Saturn", "John Smith", true));
        _books.add(new Book(0, "The Uranus", "Jane Smith", false));
        _books.add(new Book(0, "The Neptune", "John Doe", true));
        _books.add(new Book(0, "The Pluto", "Jane Doe", false));

        for (int i = 0; i < _books.size(); i++) {
            save(_books.get(i));
        }
    }

    public List<Book> findAll() {
        return books;
    }

    public List<Book> findByTitleContaining(String title) {
        return books.stream().filter(book -> book.getTitle().contains(title)).toList();
    }

    public Book findById(long id) {
        return books.stream().filter(book -> id == book.getId()).findAny().orElse(null);
    }

    public List<Book> findByAvailable(boolean isAvailable) {
        return books.stream().filter(book -> isAvailable == book.isAvailable()).toList();
    }

    public Book save(Book book) {
        // Update book
        if (book.getId() != 0) {
            long _id = book.getId();

            for (int idx = 0; idx < books.size(); idx++)
                if (_id == books.get(idx).getId()) {
                    books.set(idx, book);
                    break;
                }

            return book;
        }

        // Create new book
        book.setId(++id);
        books.add(book);
        return book;
    }

    public void deleteById(long id) {
        books.removeIf(book -> id == book.getId());
    }
}
