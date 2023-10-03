package com.example.bookmanagementsystem.datafetchers;
import com.example.bookmanagementsystem.modules.Book;
import com.example.bookmanagementsystem.services.BookService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@DgsComponent
public class BookFetchers {

	@Autowired
	private BookService bookService;

	@DgsQuery
	public Optional<Book> book(){

		System.out.println("[book call]");
		int id = 1;
		return bookService.book(id);
	}

	@DgsQuery
	public List<Book> books() {
		System.out.println("[books call]");
		System.out.println("result:"+bookService.books().toString());
		return bookService.books();
	}

	@DgsMutation
	public Book createBook(String title, int publication_year, int authorId) {
		return bookService.createBook(title, publication_year, authorId);
	}

	@DgsMutation
	public Book updateBook(int bookId, String title, int publication_year, int authorId){
		return bookService.updateBook(bookId, title, publication_year, authorId);
	}

	@DgsMutation
	public Boolean deleteBook(int bookId) throws IllegalArgumentException {
		return bookService.deleteBook(bookId);
	}


}
