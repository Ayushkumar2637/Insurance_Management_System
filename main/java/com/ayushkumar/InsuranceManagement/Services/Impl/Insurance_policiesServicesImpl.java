package com.ayushkumar.InsuranceManagement.Services.Impl;

import com.ayushkumar.InsuranceManagement.Daos.Insurance_policiesDao;
import com.ayushkumar.InsuranceManagement.Entity.Insurance_policies;
import com.ayushkumar.InsuranceManagement.Exceptions.Insurance_policiesNotFoundException;
import com.ayushkumar.InsuranceManagement.Services.Insurance_policiesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Insurance_policiesServicesImpl implements Insurance_policiesServices {

    @Autowired
    private Insurance_policiesDao insurance_policiesDao;

    @Override
    public Insurance_policies acceptInsurance_policiesDetails(Insurance_policies insurance_policies) {
        return insurance_policiesDao.save(insurance_policies);
    }

    @Override
    public Insurance_policies updateInsurance_policiesDetails(int id, Insurance_policies insurance_policies) throws Insurance_policiesNotFoundException {
        // Fetch Insurance_policies
        Insurance_policies fetchInsurance_policies=insurance_policiesDao.findById(id).orElseThrow(()->
                new Insurance_policiesNotFoundException("Insurance_policy not found for the Insurance_policy id : "+id));
        //Update Insurance_policies
        if(insurance_policies.getPolicy_number()>0)
            fetchInsurance_policies.setPolicy_number(insurance_policies.getPolicy_number());
        if(insurance_policies.getPolicy_type()!=null)
            fetchInsurance_policies.setPolicy_type(insurance_policies.getPolicy_type());
        if(insurance_policies.getCoverage_amount()>0)
            fetchInsurance_policies.setCoverage_amount(insurance_policies.getCoverage_amount());
        if(insurance_policies.getPremium()>0)
            fetchInsurance_policies.setPremium(insurance_policies.getPremium());
        if(insurance_policies.getStart_date()!=null)
            fetchInsurance_policies.setStart_date(insurance_policies.getStart_date());
        if(insurance_policies.getEnd_date()!=null)
            fetchInsurance_policies.setEnd_date(insurance_policies.getEnd_date());
        if(insurance_policies.getClients()!=null)
            fetchInsurance_policies.setClients(insurance_policies.getClients());
        if(insurance_policies.getClaims()!=null)
            fetchInsurance_policies.setClaims(insurance_policies.getClaims());
        // Save in db
        return insurance_policiesDao.save(fetchInsurance_policies);
    }

    @Override
    public Insurance_policies getInsurance_policiesById(int id) throws Insurance_policiesNotFoundException {
        Insurance_policies fetchInsurance_policies=insurance_policiesDao.findById(id).orElseThrow(()->
                new Insurance_policiesNotFoundException("Insurance_policy not found for the Insurance_policy id : "+id));
        return fetchInsurance_policies;
    }

    @Override
    public List<Insurance_policies> getAllInsurance_policies() {
        return insurance_policiesDao.findAll();
    }

    @Override
    public boolean deleteInsurance_policiesDetails(int id) {
        insurance_policiesDao.deleteById(id);
        return true;
    }
}
