package com.bnpparibas.itg.mylibraries.libraries.exposition;

import com.bnpparibas.itg.mylibraries.libraries.domain.library.Address;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Director;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Library;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.book.Book;

import java.util.List;
import java.util.stream.Collectors;

public class LibraryAdapter {
    private LibraryAdapter(){}

    public static Library TransformToLibrary (LibraryDTO libraryDTO){
        Address address = new Address(
                libraryDTO.addressDTO.number,
                libraryDTO.addressDTO.street,
                libraryDTO.addressDTO.postalCode,
                libraryDTO.addressDTO.city);

        Director director = new Director(
                libraryDTO.directorDTO.surname,
                libraryDTO.directorDTO.name);

        return new Library(null, libraryDTO.type, address, director, transformToListBooks(libraryDTO.bookDTOList));
    }

    public static List<Book> transformToListBooks(List<LibraryDTO.BookDTO> bookDTOS){
        return bookDTOS
                .stream()
                .map(bookDTO -> new Book(bookDTO.title,bookDTO.author,bookDTO.numberOfPages,bookDTO.literaryGenre))
                .collect(Collectors.toList());
    }

    public static LibraryDTO adaptToLibraryDTO (Library library){
        return new LibraryDTO(
                library.getType(),
                new LibraryDTO.AddressDTO(library.getAddress().getNumber(),
                        library.getAddress().getStreet(),
                        library.getAddress().getPostalCode(),
                        library.getAddress().getCity()),
                new LibraryDTO.DirectorDTO(library.getDirector().getSurname(),
                        library.getDirector().getName()),
                adaptToBookListDTO(library.getBooks())
        );
    }

    public  static List<LibraryDTO.BookDTO> adaptToBookListDTO(List<Book> books) {
        return books.stream().map(book -> adaptToBookDTO(book)).collect(Collectors.toList());
    }

    public static LibraryDTO.BookDTO adaptToBookDTO(Book book) {
        return new LibraryDTO.BookDTO(
                book.getTitle(),
                book.getAuthor(),
                book.getNumberOfPages(),
                book.getLiteraryGenre()
        );
    }

    public static List<LibraryDTO> adaptToLibraryDTOList(List<Library> libraries){
        return libraries.stream().map(library -> adaptToLibraryDTO(library)).collect(Collectors.toList());
    }
}
