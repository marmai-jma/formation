package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import com.bnpparibas.itg.mylibraries.libraries.domain.library.book.Book;

import java.util.List;

public class Library {
    private Long id;
    private Type type;
    private Address address;
    private Director director;
    private List<Book> books;

    private Library() {}

    // public Library(Type type, Address address, Director director,List<Book> books) {
    public Library(Long id, Type type, Address address, Director director,List<Book> books) {
        this.id = id;
        this.type = type;
        this.address = address;
        this.director = director;
        this.books = books;
    }

    public void udpate(Library libraryWithNewData) {
        this.type = libraryWithNewData.getType();
        this.address = libraryWithNewData.getAddress();
        this.director = libraryWithNewData.getDirector();
    }

    public Long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Address getAddress() {
        return address;
    }

    public Director getDirector() {
        return director;
    }

    public List<Book> getBooks() {
        return books;
    }
}
