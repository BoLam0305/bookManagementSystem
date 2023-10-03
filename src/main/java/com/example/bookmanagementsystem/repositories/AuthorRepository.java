package com.example.bookmanagementsystem.repositories;
import com.example.bookmanagementsystem.modules.Author;
import java.util.List;

import com.example.bookmanagementsystem.modules.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	List<Author>findByIdIn(List<Integer> authorIds);
}
