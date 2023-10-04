package com.example.bookmanagementsystem.services.serviceImp;

import com.example.bookmanagementsystem.modules.Author;
import com.example.bookmanagementsystem.modules.Book;
import com.example.bookmanagementsystem.repositories.AuthorRepository;
import com.example.bookmanagementsystem.repositories.BookRepository;
import com.example.bookmanagementsystem.services.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Optional<Book> book(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> books() {
        return bookRepository.findAll();
    }

    public Map<Integer, List<Book>> findByIdIn(Set<Integer> authorsId) {
        List<Book> books = bookRepository.findByAuthorIdIn(authorsId);
        return books.stream()
              .collect(Collectors.groupingBy(Book::getAuthorId));
    }

    @Override
    public Book createBook(String title, int publication_year, int authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author == null) {
            throw new IllegalArgumentException("Author not found with ID: " + authorId);
        }
        Book book = new Book();
        book.setTitle(title);
        book.setPublication_year(publication_year);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(int bookId, String title, int publication_year, int authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);
        if (author == null) {
            throw new IllegalArgumentException("Author not found with ID: " + authorId);
        }
        if (book == null) {
            throw new IllegalArgumentException("Book not found with ID: " + authorId);
        }
        book.setTitle(title);
        book.setPublication_year(publication_year);
        book.setAuthor(author);
        return book;
    }

    @Override
    public Boolean deleteBook(int bookId) throws IllegalArgumentException {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null) {
            return false;
        } else {
            bookRepository.delete(book);
            return true;
        }
    }


}
