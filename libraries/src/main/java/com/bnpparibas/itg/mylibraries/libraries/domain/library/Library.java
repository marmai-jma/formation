package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import javax.persistence.*;

@Entity(name = "LIBRARY")
public class Library {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private Type type;
    @Embedded
    private Address address;
    @Embedded
    private Director director;

    private Library() {}

    public Library(Long id, Type type, Address address, Director director) {
        this.id = id;
        this.type = type;
        this.address = address;
        this.director = director;
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
}
