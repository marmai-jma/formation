package com.bnpparibas.itg.mylibraries.libraries.exposition;

import com.bnpparibas.itg.mylibraries.libraries.application.LibraryService;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // indique que cette classe controle les API Rest
public class LibraryRessource {
    @Autowired
    private LibraryService libraryService;

    @RequestMapping(method = RequestMethod.POST,path = {"/libraries/"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createLibrary (@RequestBody Library library){
        return this.libraryService.create(library);
    }

    @RequestMapping(method = RequestMethod.GET,path = {"/libraries/{libraryId}"})
    public Library obtainLibrary (@PathVariable("libraryId") Long id){
        return this.libraryService.obtain(id);
    }

    @RequestMapping(method = RequestMethod.GET,path = {"/libraries/"})
    public List<Library> findAllLibary (){
        return this.libraryService.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT,path = {"/libraries/{libraryId}"})
    public void updateLibrary (@PathVariable("libraryId") Long id, @RequestBody Library library){
        this.libraryService.update(id, library);
    }

    @RequestMapping(method = RequestMethod.DELETE,path = {"/libraries/{libraryId}"})
    public void deleteLibrary (@PathVariable("libraryId") Long id){
        this.libraryService.delete(id);
    }
}
