package com.example.bookmanagementsystem.services.serviceImp;

import com.example.bookmanagementsystem.modules.Author;
import com.example.bookmanagementsystem.repositories.AuthorRepository;
import com.example.bookmanagementsystem.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImp implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> findByIdIn(List<Integer> authorsId) {
        return authorRepository.findByIdIn(authorsId);
    }
}
