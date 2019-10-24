package com.bnpparibas.itg.mylibraries.libraries.exposition.exception;

import com.bnpparibas.itg.mylibraries.libraries.domain.exception.MyLibraryException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

//@ControllerAdvice catch centralisé - SPRING ecoute toutes les classes du basePackages
@ControllerAdvice(basePackages = "com.bnpparibas.itg.mylibraries.libraries")
public class MyExceptionHandler {
    @ResponseBody //sérialiser l'objet Java en JSON
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // erreurs métier de type 500 pb serveur = choix de conception
    @ExceptionHandler(value = MyLibraryException.class) // écouter toutes les erreurs de type MyLibraryexception
                                                        // jetées dans le package en référence de @ControllerAdvise
    public TreeSet<String> handleBusinessException (MyLibraryException exceptions){
        Set<String> exceptionErrors = exceptions.getCodeErreurs();
        return new TreeSet<>(exceptionErrors); // pour pas conserver les doublons
    }

    @ResponseBody //sérialiser l'objet Java en JSON
    @ResponseStatus(HttpStatus.BAD_REQUEST) // erreurs de surface de type 400
    @ExceptionHandler(value = MethodArgumentNotValidException.class) // écouter toutes les erreurs de type MyLibraryexception
    // jetées dans le package en référence de @ControllerAdvise
    public TreeSet<String> handleSpringSurfaceException (MethodArgumentNotValidException exceptions){
        Set<String> surfaceErrors = exceptions
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toSet());
        return new TreeSet<>(surfaceErrors); // pour pas conserver les doublons
    }
}
