package com.ayushkumar.InsuranceManagement.Services;

import com.ayushkumar.InsuranceManagement.Entity.Claims;
import com.ayushkumar.InsuranceManagement.Exceptions.ClaimsDetailsNotFoundException;

import java.util.List;

public interface ClaimsServices {
    Claims acceptClaimsDetails(Claims claims);
    Claims updateClaimsDetails(int id,Claims claims) throws ClaimsDetailsNotFoundException;
    Claims getClaimsById(int id) throws ClaimsDetailsNotFoundException;
    List<Claims> getAllClaims();
    boolean deleteClaimsDetails(int id);
}
