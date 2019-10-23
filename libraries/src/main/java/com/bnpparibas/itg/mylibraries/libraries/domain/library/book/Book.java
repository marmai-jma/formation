package com.bnpparibas.itg.mylibraries.libraries.domain.library.book;

import javax.persistence.*;

@Entity(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "NUMBER_OF_PAGES")
    private int numberOfPages;

    @Enumerated(EnumType.STRING)
    @Column(name = "LITERARY_GENRE")
    private LiteraryGenre literaryGenre;

    private Book(){};

    public Book(String title, String author, int numberOfPages, LiteraryGenre literaryGenre) {
   //     this.id = id;
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.literaryGenre = literaryGenre;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public LiteraryGenre getLiteraryGenre() {
        return literaryGenre;
    }
}
