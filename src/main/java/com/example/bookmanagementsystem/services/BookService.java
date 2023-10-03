package com.example.bookmanagementsystem.services;

import com.example.bookmanagementsystem.modules.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
	Optional<Book> book(Integer id);
	List<Book> books();
	Book createBook(String title, int publication_year, int authorId);
	Book updateBook(int bookId, String title, int publication_year, int authorId);
	Boolean deleteBook(int bookId);

}
