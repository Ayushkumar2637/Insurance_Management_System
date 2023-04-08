package com.ayushkumar.InsuranceManagement.Validators;

import com.ayushkumar.InsuranceManagement.Dtos.Insurance_policiesDto;
import com.ayushkumar.InsuranceManagement.Exceptions.InvalidInsurancePolicyRequestBodyException;

public class Insurance_policiesValidator {
    public static boolean isValid(Insurance_policiesDto insurance_policiesDto) throws InvalidInsurancePolicyRequestBodyException {
        if(insurance_policiesDto.getPolicy_number()<=0)
            throw new InvalidInsurancePolicyRequestBodyException("Insurance policy number is invalid");
        if(insurance_policiesDto.getPolicy_type()==null || insurance_policiesDto.getPolicy_type().equals(""))
            throw new InvalidInsurancePolicyRequestBodyException("Insurance policy type is empty or null");
        if(insurance_policiesDto.getCoverage_amount()<=0)
            throw new InvalidInsurancePolicyRequestBodyException("Insurance policy coverage amount is invalid");
        if(insurance_policiesDto.getPremium()<=0)
            throw new InvalidInsurancePolicyRequestBodyException("Insurance policy premium is invalid");
        if(insurance_policiesDto.getStart_date()==null)
            throw new InvalidInsurancePolicyRequestBodyException("Insurance policy start date is null");
        if(insurance_policiesDto.getEnd_date()==null)
            throw new InvalidInsurancePolicyRequestBodyException("Insurance policy end date is null");
        if(insurance_policiesDto.getClients_id()<=0)
            throw new InvalidInsurancePolicyRequestBodyException("Insurance policy client id is Invalid");
        return true;
    }
}
