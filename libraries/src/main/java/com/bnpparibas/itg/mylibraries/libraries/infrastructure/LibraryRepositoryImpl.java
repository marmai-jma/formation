package com.bnpparibas.itg.mylibraries.libraries.infrastructure;

import com.bnpparibas.itg.mylibraries.libraries.domain.exception.ErrorCodes;
import com.bnpparibas.itg.mylibraries.libraries.domain.exception.MyLibraryException;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Library;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {

    @Autowired
    private LibraryDAO libraryDAO;

    @Override
    public Long save(Library library) {
        LibraryJPA libraryJPA = libraryDAO.save(new LibraryJPA(library));
        return libraryJPA.getId();
    }

    @Override
    public Library obtain(Long id) {
        return libraryDAO
                .findById(id)
                .map(LibraryJPA::toLibrary)
                .orElseThrow(()-> new MyLibraryException(ErrorCodes.LIBRARY_NOT_FOUND));
    }

    @Override
    public List<Library> findAll() {
        return libraryDAO.findAll().stream()
                .map(LibraryJPA::toLibrary)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        libraryDAO.deleteById(id);
    }
}
