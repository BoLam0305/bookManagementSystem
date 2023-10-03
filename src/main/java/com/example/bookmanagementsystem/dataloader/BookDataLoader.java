package com.example.bookmanagementsystem.dataloader;

import com.example.bookmanagementsystem.modules.Book;
import com.example.bookmanagementsystem.services.BookService;
import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.BatchLoader;
import org.dataloader.MappedBatchLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@DgsDataLoader(name = "books")
public class BookDataLoader implements MappedBatchLoader<Integer, Book> {
    @Autowired
    private BookService bookService;

    @Override
    public CompletionStage<Map<Integer, Book>> load(Set<Integer> booksId) {
        return CompletableFuture.supplyAsync(() -> bookService.findByIdIn(booksId));
    }
}
