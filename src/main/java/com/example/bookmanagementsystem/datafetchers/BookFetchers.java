package com.example.bookmanagementsystem.datafetchers;
import com.example.bookmanagementsystem.modules.Author;
import com.example.bookmanagementsystem.modules.Book;
import com.example.bookmanagementsystem.services.BookService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;


@DgsComponent
public class BookFetchers {

	@Autowired
	private BookService bookService;

//	@DgsData(parentType = "Author", field = "book")
//	public CompletableFuture<Author> author(DgsDataFetchingEnvironment dfe) throws ExecutionException, InterruptedException {
//		System.out.println("[books data loader call]");
//		DataLoader<Integer, Author> dataLoader = dfe.getDataLoader("books");
//		Author author = dfe.getSource();
//		return dataLoader.load(author.getBooks());
//	}

	@DgsQuery
	public Optional<Book> book(){
		System.out.println("[book call]");
		int id = 1;
		return bookService.book(id);
	}

	@DgsQuery
	public List<Book> books() {
		System.out.println("[books call]");
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
