package com.example.bookmanagementsystem.datafetchers;
import com.example.bookmanagementsystem.modules.Author;
import com.example.bookmanagementsystem.modules.Book;
import com.example.bookmanagementsystem.services.BookService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;


@DgsComponent
public class BookFetchers {

	@Autowired
	private BookService bookService;

	@DgsData(parentType = "Author", field = "books")
	public CompletableFuture<Book> book(DgsDataFetchingEnvironment dfe) throws ExecutionException, InterruptedException {
		System.out.println("[books data loader call]");
		DataLoader<Integer, Book> dataLoader = dfe.getDataLoader("books");
		Author author = dfe.getSource();
//		Set<Integer> booksId = author.getBooks().stream().map(Book::getId).collect(Collectors.toSet());
//		System.out.println(booksId);
		return dataLoader.load(author.getId());
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
