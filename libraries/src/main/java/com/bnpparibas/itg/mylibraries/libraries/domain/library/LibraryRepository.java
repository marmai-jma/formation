package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import com.bnpparibas.itg.mylibraries.libraries.domain.ddd.DDD;

import java.util.List;

@DDD.Repository
public interface LibraryRepository {
    Long save(Library Library);

    Library obtain (Long id);

    List<Library> findAll ();

    void delete (Long id);
}
