package com.ayushkumar.InsuranceManagement.Validators;

import com.ayushkumar.InsuranceManagement.Dtos.ClaimsDto;
import com.ayushkumar.InsuranceManagement.Exceptions.InvalidClaimsRequestBodyException;

public class ClaimsDtoValidator {
    public static boolean isValid(ClaimsDto claimsDto) throws InvalidClaimsRequestBodyException {
        if(claimsDto.getClaim_number()<=0)
            throw new InvalidClaimsRequestBodyException("Claim number is Invalid");
        if(claimsDto.getDescription()==null || claimsDto.getDescription().equals(""))
            throw new InvalidClaimsRequestBodyException("Claim description is empty or null");
        if(claimsDto.getClaim_date()==null)
            throw new InvalidClaimsRequestBodyException("Claim date is empty or null");
        if(claimsDto.getClaim_status()==null || claimsDto.getClaim_status().equals(""))
            throw new InvalidClaimsRequestBodyException("Claim status is empty or null");
        if(claimsDto.getInsurance_policies_id()<=0)
            throw new InvalidClaimsRequestBodyException("Claim Insurance policy is Invalid");
        return true;
    }
}
