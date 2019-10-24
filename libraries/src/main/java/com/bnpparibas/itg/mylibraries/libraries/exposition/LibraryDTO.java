package com.bnpparibas.itg.mylibraries.libraries.exposition;

import com.bnpparibas.itg.mylibraries.libraries.domain.exception.ErrorCodes;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Type;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.book.LiteraryGenre;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class LibraryDTO {
    @JsonProperty
    Type type;

    @Valid
    @NotNull(message = ErrorCodes.LIBRARY_MUST_HAVE_AN_ADDRESS)
    @JsonProperty("address")
    AddressDTO addressDTO;

    @Valid
    @NotNull(message = ErrorCodes.LIBRARY_MUST_HAVE_A_DIRECTOR)
    @JsonProperty("director")
    DirectorDTO directorDTO;

    @JsonProperty("books")
    List<BookDTO> bookDTOList;

    public static class AddressDTO {
        @JsonProperty int number;
        @JsonProperty String street;
        @JsonProperty int postalCode;
        @JsonProperty String city;

        public AddressDTO(int number, String street, int postalCode, String city) {
            this.number = number;
            this.street = street;
            this.postalCode = postalCode;
            this.city = city;
        }
    }

    public static class DirectorDTO {
        @JsonProperty String surname;
        @JsonProperty String name;

        public DirectorDTO(String surname, String name) {
            this.surname = surname;
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public String getName() {
            return name;
        }
    }

    public static class BookDTO {
        @JsonProperty String title;
        @JsonProperty String author;
        @JsonProperty int numberOfPages;
        @JsonProperty LiteraryGenre literaryGenre;

        public BookDTO(String title, String author, int numberOfPages, LiteraryGenre literaryGenre) {
            this.title = title;
            this.author = author;
            this.numberOfPages = numberOfPages;
            this.literaryGenre = literaryGenre;
        }
    }

    public LibraryDTO(Type type, AddressDTO addressDTO, DirectorDTO directorDTO, List<BookDTO> bookDTOList) {
        this.type = type;
        this.addressDTO = addressDTO;
        this.directorDTO = directorDTO;
        this.bookDTOList = bookDTOList;
    }

    public DirectorDTO getDirectorDTO() {
        return directorDTO;
    }
}
