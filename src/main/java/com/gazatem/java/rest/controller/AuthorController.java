package com.gazatem.java.rest.controller;

import com.gazatem.java.rest.domain.Book;
import com.gazatem.java.rest.repository.BookRepository;
import com.gazatem.java.rest.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}/books")
    public List<Book> getAllBooksByAuthorId() {
        List<Book> books = bookRepository.findAll();
        return books;
    }
}
