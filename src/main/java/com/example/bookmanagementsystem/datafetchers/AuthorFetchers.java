package com.example.bookmanagementsystem.datafetchers;

import com.example.bookmanagementsystem.dataloader.AuthorDataLoader;
import com.example.bookmanagementsystem.modules.Author;
import com.example.bookmanagementsystem.modules.Book;
import com.example.bookmanagementsystem.repositories.AuthorRepository;
import com.netflix.graphql.dgs.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class AuthorFetchers {
    @Autowired
    private AuthorRepository authorRepository;

    @DgsData(parentType = "Book", field = "author")
    public CompletableFuture<Author> author(DgsDataFetchingEnvironment dfe) throws ExecutionException, InterruptedException {
        System.out.println("[authors data loader call]");
        DataLoader<Integer, Author> dataLoader = dfe.getDataLoader("authors");
        Book book = dfe.getSource();
        return dataLoader.load(book.getAuthor().getId());
    }


    @DgsQuery
    public List<Author> authors() {
        System.out.println("[authors call]");
        return authorRepository.findAll();
    }

    @DgsMutation
    public Author createAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }

    @DgsMutation
    public Author updateAuthor(int id, String name) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) {
            throw new IllegalArgumentException("Author not found with ID: " + id);
        }
        author.setName(name);
        return authorRepository.save(author);
    }

    @DgsMutation
    public Boolean deleteAuthor(int id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) {
            return false;
        } else {
            authorRepository.delete(author);
            return true;
        }
    }
}
