package com.ayushkumar.InsuranceManagement.ExceptionHandler;

import com.ayushkumar.InsuranceManagement.Exceptions.ClaimsDetailsNotFoundException;
import com.ayushkumar.InsuranceManagement.Exceptions.InvalidClaimsRequestBodyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClaimsExceptionHandler {

    @ExceptionHandler(ClaimsDetailsNotFoundException.class)
    public ResponseEntity handleClaimsDetailsNotFoundException(){
        return new ResponseEntity("Invalid Claims Details Passed", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidClaimsRequestBodyException.class)
    public ResponseEntity handleInvalidClaimsRequestBodyException(){
        return new ResponseEntity("Invalid Claims Data Is Passed",HttpStatus.BAD_REQUEST);
    }

}
