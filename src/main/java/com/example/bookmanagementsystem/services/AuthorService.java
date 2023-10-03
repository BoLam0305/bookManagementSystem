package com.example.bookmanagementsystem.services;

import com.example.bookmanagementsystem.modules.Author;
import com.example.bookmanagementsystem.modules.Book;

import java.util.List;
import java.util.Map;

public interface AuthorService {
	List<Author> findByIdIn(List<Integer> authorsId);



}
