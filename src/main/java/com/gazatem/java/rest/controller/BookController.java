package com.gazatem.java.rest.controller;

import com.gazatem.java.rest.domain.Book;
import com.gazatem.java.rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value="/books", method= RequestMethod.GET)
    public List<Book> shopListPage() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/book/{bookId}")
    ResponseEntity<Book> getBook(@PathVariable Long bookId) {
        Book book = bookRepository.findOne(bookId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/book/{book}")
                .buildAndExpand(book, book.getId())
                .toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriOfNewResource);

        return new ResponseEntity<Book>(book, httpHeaders, HttpStatus.CREATED);
    }

}
