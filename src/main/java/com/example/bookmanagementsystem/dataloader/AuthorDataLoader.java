package com.example.bookmanagementsystem.dataloader;

import com.example.bookmanagementsystem.modules.Author;
import com.example.bookmanagementsystem.services.AuthorService;
import org.dataloader.BatchLoader;
import com.netflix.graphql.dgs.DgsDataLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@DgsDataLoader(name = "authors")
public class AuthorDataLoader implements BatchLoader<Integer, Author> {

    @Autowired
    AuthorService authorService;

    @Override
    public CompletionStage<List<Author>> load(List<Integer> keys) {
        return CompletableFuture.supplyAsync(() -> authorService.findByIdIn(keys));
    }
}
