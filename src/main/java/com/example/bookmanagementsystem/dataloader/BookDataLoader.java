package com.example.bookmanagementsystem.dataloader;

import com.example.bookmanagementsystem.modules.Book;
import com.example.bookmanagementsystem.services.BookService;
import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.MappedBatchLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@DgsDataLoader
public class BookDataLoader implements MappedBatchLoader<Integer, List<Book>> {
    @Autowired
    private BookService bookService;

    @Override
    public CompletionStage<Map<Integer, List<Book>>> load(Set<Integer> set) {
        return null;
    }
}
