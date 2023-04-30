package br.com.iteris.universidade.adocaoanimais.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
public class AnimalInvalidException extends RuntimeException {
    public AnimalInvalidException(String message){
        super(message);
    }
}