package br.com.erudio.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.erudio.exceptions.ExceptionsResponse;
import br.com.erudio.exceptions.UnsupportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizedReponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionsResponse> handleAllExceptions (
            Exception ex, WebRequest request){
        ExceptionsResponse exceptionsResponse = new ExceptionsResponse(
            new Date(), 
            ex.getMessage(),
            request.getDescription(false));    
        return new ResponseEntity<ExceptionsResponse>(exceptionsResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionsResponse> handleBadRequestExceptions (
            Exception ex, WebRequest request){
        ExceptionsResponse exceptionsResponse = new ExceptionsResponse(
            new Date(), 
            ex.getMessage(),
            request.getDescription(false));    
        return new ResponseEntity<ExceptionsResponse>(exceptionsResponse, HttpStatus.BAD_REQUEST);

    }
}
