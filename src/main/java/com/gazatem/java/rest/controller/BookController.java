package com.gazatem.java.rest.controller;

import com.gazatem.java.rest.domain.Book;
import com.gazatem.java.rest.model.BookDetails;
import com.gazatem.java.rest.repository.BookRepository;
import com.gazatem.java.rest.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.data.domain.Sort.Direction;
import java.net.URI;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookRepository bookRepository;

    @Inject
    private BookService bookService;


    @RequestMapping(value="/books", method= RequestMethod.GET)
    public List<Book> shopListPage() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Page<BookDetails>> getAllBooks(
            @PageableDefault(page = 0, size = 10, sort = "title", direction = Direction.DESC) Pageable page) {

        Page<BookDetails> books = bookService.getBookDetails(page);

        return new ResponseEntity<>(books, HttpStatus.OK);
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
