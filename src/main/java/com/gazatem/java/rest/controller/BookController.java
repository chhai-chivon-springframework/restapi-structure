package com.gazatem.java.rest.controller;

import com.gazatem.java.rest.domain.Book;
import com.gazatem.java.rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value="/lists", method= RequestMethod.GET)
    public List<Book> shopListPage() {
        List<Book> books = bookRepository.findAll();
        return books;
    }
}
