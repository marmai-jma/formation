package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import com.bnpparibas.itg.mylibraries.libraries.domain.ddd.DDD;
import com.bnpparibas.itg.mylibraries.libraries.domain.exception.MyLibraryException;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.book.Book;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@DDD.AggregateRoot
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
        validate();
    }

    public void udpate(Library libraryWithNewData) {
        this.type = libraryWithNewData.getType();
        this.address = libraryWithNewData.getAddress();
        this.director = libraryWithNewData.getDirector();
        validate();
    }

    public void validate(){
        Set<String>errors = new HashSet<>();
        this.director.validate(errors);
        this.address.validate(errors);
        if(!errors.isEmpty()){
            throw(new MyLibraryException(errors));
        }
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
