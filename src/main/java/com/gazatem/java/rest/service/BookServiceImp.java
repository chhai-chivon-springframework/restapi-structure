package com.gazatem.java.rest.service;


import com.gazatem.java.rest.domain.Book;
import com.gazatem.java.rest.model.BookDetails;
import com.gazatem.java.rest.repository.BookRepository;
import com.gazatem.java.rest.utility.DTOUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BookServiceImp implements BookService {

    @Inject
    private BookRepository bookRepository;


    @Override
    public Page<BookDetails> getBookDetails(Pageable page) {

        Page<Book> books = bookRepository.findAll(page);

        return DTOUtils.mapPage(books, BookDetails.class);
    }
}
