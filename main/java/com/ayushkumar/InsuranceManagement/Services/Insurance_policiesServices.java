package com.ayushkumar.InsuranceManagement.Services;

import com.ayushkumar.InsuranceManagement.Entity.Insurance_policies;
import com.ayushkumar.InsuranceManagement.Exceptions.Insurance_policiesNotFoundException;

import java.util.List;

public interface Insurance_policiesServices {
    Insurance_policies acceptInsurance_policiesDetails(Insurance_policies insurance_policies);
    Insurance_policies updateInsurance_policiesDetails(int id,Insurance_policies insurance_policies) throws Insurance_policiesNotFoundException;
    Insurance_policies getInsurance_policiesById(int id) throws Insurance_policiesNotFoundException;
    List<Insurance_policies> getAllInsurance_policies();
    boolean deleteInsurance_policiesDetails(int id);
}
