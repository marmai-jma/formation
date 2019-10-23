package com.bnpparibas.itg.mylibraries.libraries.application;

import com.bnpparibas.itg.mylibraries.libraries.domain.library.Library;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public Long create(Library newLibrary) {
       return this.libraryRepository.save(newLibrary);
    }

    public Library obtain (Long id){
        return this.libraryRepository
                .obtain(id);
     //         .orElseThrow(()->new MyLibraryException(ErrorCodes.LIBRARY_NOT_FOUND));
    }

    public List <Library> findAll (){
        return this.libraryRepository.findAll();
    }

    public void update (Long id, Library libraryWithNewData){
        Library library = obtain(id);
        library.udpate(libraryWithNewData);
        this.libraryRepository.save(library);
    }

    public void delete (Long id){
        Library library = obtain(id);
        this.libraryRepository.delete(id);
    }
}
