package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import com.bnpparibas.itg.mylibraries.libraries.domain.exception.ErrorCodes;
import org.springframework.util.StringUtils;

import java.util.Set;

public class Director {

    private String surname;
    private String name;

    private Director() {}

    public Director(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }
    public void validate(Set<String> errors){
        if (this == null){
            errors.add(ErrorCodes.LIBRARY_MUST_HAVE_A_DIRECTOR);
        }
        if (StringUtils.isEmpty(this.surname)){
            errors.add(ErrorCodes.DIRECTOR_MUST_HAVE_A_SURNAME);
        }
        if (StringUtils.isEmpty(this.name)){
            errors.add(ErrorCodes.DIRECTOR_MUST_HAVE_A_NAME);
        }
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }
}
