package com.gazatem.java.rest.service;

import com.gazatem.java.rest.model.BookDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    public Page<BookDetails> getBookDetails(Pageable pag);
}
