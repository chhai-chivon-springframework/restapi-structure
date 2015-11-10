package com.gazatem.java.rest.domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "author")
    private Set<Book> books = new HashSet<Book>();

}
