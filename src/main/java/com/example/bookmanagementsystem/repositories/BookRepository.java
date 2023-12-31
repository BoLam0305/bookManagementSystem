package com.example.bookmanagementsystem.repositories;

import com.example.bookmanagementsystem.modules.Book;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book>findByIdIn(Set<Integer> booksId);
    List<Book>findByAuthorIdIn(Set<Integer>authorIds);

}
