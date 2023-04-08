package com.ayushkumar.InsuranceManagement.ExceptionHandler;

import com.ayushkumar.InsuranceManagement.Exceptions.ClientsDetailsNotFoundException;
import com.ayushkumar.InsuranceManagement.Exceptions.InvalidClientsRequestBodyException;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientsExceptionHandler {

    @ExceptionHandler(ClientsDetailsNotFoundException.class)
    public ResponseEntity handleClientsDetailsNotFoundException() {
        return new ResponseEntity("Invalid Client Details Passed", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidClientsRequestBodyException.class)
    public ResponseEntity handleInvalidClientsRequestBodyException() {
        return new ResponseEntity("Invalid Client Data Is Passed", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity handleExceptionForAllDeleteMethod() {
        return new ResponseEntity("Invalid ID", HttpStatus.BAD_REQUEST);
    }

}
