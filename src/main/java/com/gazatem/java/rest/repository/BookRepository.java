package com.gazatem.java.rest.repository;

import com.gazatem.java.rest.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}