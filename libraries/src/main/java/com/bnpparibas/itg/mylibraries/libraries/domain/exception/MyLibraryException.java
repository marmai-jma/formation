package com.bnpparibas.itg.mylibraries.libraries.domain.exception;

import javafx.scene.effect.SepiaTone;

import java.util.HashSet;
import java.util.Set;

public class MyLibraryException extends RuntimeException {
    private Set<String> codeErreurs = new HashSet<>();

    public MyLibraryException (String codeErreur) {
        this.codeErreurs.add(codeErreur);
    }

    public MyLibraryException(Set<String> codeErreurs) {this.codeErreurs= codeErreurs; }

    public Set<String> getCodeErreurs() {
        return codeErreurs;
    }
}
