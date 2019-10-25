package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import java.util.Objects;

public class Director {

    private String surname;
    private String name;

    private Director() {}

    public Director(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return Objects.equals(surname, director.surname) &&
                Objects.equals(name, director.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name);
    }
}
