package com.crm.exception;

import com.crm.payload.ErrorDetails;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

//by adding this annotation this class act as a global exception handler.
@ControllerAdvice
public class HandleException
{
    //this annotation specifies that this method should handle which type of exception.it should handle by providing the exception type in the argument.
    @ExceptionHandler(Exception.class)
   public ResponseEntity<ErrorDetails> Exception(Exception e, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails
                ( new Date(),
                        e.getMessage(),
                        request.getDescription(false)
                );
       return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
   };
}
