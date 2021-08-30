package br.com.digitalinnovatione.saladereuniao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExecption extends Exception{
    private static final long serialVersionUID = 1l;
    public ResourceNotFoundExecption(String message){
        super(message);
    }
}
