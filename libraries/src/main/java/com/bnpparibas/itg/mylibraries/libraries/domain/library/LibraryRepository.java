package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import java.util.List;

public interface LibraryRepository {
    Long save(Library Library);

    Library obtain (Long id);

    List<Library> findAll ();

    void delete (Long id);
}
