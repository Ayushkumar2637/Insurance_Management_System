package com.ayushkumar.InsuranceManagement.Services.Impl;

import com.ayushkumar.InsuranceManagement.Daos.ClaimsDao;
import com.ayushkumar.InsuranceManagement.Entity.Claims;
import com.ayushkumar.InsuranceManagement.Exceptions.ClaimsDetailsNotFoundException;
import com.ayushkumar.InsuranceManagement.Services.ClaimsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimsServicesImpl implements ClaimsServices {

    @Autowired
    private ClaimsDao claimsDao;

    @Override
    public Claims acceptClaimsDetails(Claims claims) {
        return claimsDao.save(claims);
    }

    @Override
    public Claims updateClaimsDetails(int id, Claims claims) throws ClaimsDetailsNotFoundException {
        // Fetch Claim
        Claims fetchClaim=claimsDao.findById(id).orElseThrow(()->
                new ClaimsDetailsNotFoundException("Claim not found for the claim id : "+id));
        // Update Claim
        if(claims.getClaim_number()>0)
            fetchClaim.setClaim_number(claims.getClaim_number());
        if(claims.getDescription()!=null)
            fetchClaim.setDescription(claims.getDescription());
        if(claims.getClaim_date()!=null)
            fetchClaim.setClaim_date(claims.getClaim_date());
        if(claims.getClaim_status()!=null)
            fetchClaim.setClaim_status(claims.getClaim_status());
        if(claims.getInsurance_policies()!=null)
            fetchClaim.setInsurance_policies(claims.getInsurance_policies());
        // save in db
        return claimsDao.save(fetchClaim);
    }

    @Override
    public Claims getClaimsById(int id) throws ClaimsDetailsNotFoundException {
        Claims fetchClaim=claimsDao.findById(id).orElseThrow(()->
                new ClaimsDetailsNotFoundException("Claim not found for the claim id : "+id));
        return fetchClaim;
    }

    @Override
    public List<Claims> getAllClaims() {
        return claimsDao.findAll();
    }

    @Override
    public boolean deleteClaimsDetails(int id) {
        claimsDao.deleteById(id);
        return true;
    }
}
