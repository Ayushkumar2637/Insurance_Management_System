package com.ayushkumar.InsuranceManagement.ExceptionHandler;

import com.ayushkumar.InsuranceManagement.Exceptions.Insurance_policiesNotFoundException;
import com.ayushkumar.InsuranceManagement.Exceptions.InvalidInsurancePolicyRequestBodyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Insurance_policiesExceptionHandler {

    @ExceptionHandler(Insurance_policiesNotFoundException.class)
    public ResponseEntity handleInsurance_policiesNotFoundException(){
        return new ResponseEntity("Invalid Insurance Policy Details Passed", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidInsurancePolicyRequestBodyException.class)
    public ResponseEntity handleInvalidInsurancePolicyRequestBodyException(){
        return new ResponseEntity("Invalid Insurance Policy Data Is Passed",HttpStatus.BAD_REQUEST);
    }

}
