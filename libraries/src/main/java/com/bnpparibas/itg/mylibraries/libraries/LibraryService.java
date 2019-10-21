package com.bnpparibas.itg.mylibraries.libraries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class LibraryService {
    @Autowired
    private LibraryDAO libraryDAO;

    public Long create(Library newLibrary) {
        Library library = this.libraryDAO.save(newLibrary);
        return library.getId();
    }

    public Library obtain (Long id){
        return this.libraryDAO
                .findById(id)
                .orElseThrow(()->new RuntimeException("LIBRARY NOT FOUND"));
    }

    public List <Library> findAll (){
        return this.libraryDAO.findAll();
    }

    public void update (Long id, Library libraryWithNewData){
        Library library = obtain(id);
        library.udpate(libraryWithNewData);
        this.libraryDAO.save(library);
    }

    public void delete (Long id){
        Library library = obtain(id);
        this.libraryDAO.delete(library);
    }
}
