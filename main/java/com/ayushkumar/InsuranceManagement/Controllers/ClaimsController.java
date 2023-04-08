package com.ayushkumar.InsuranceManagement.Controllers;

import com.ayushkumar.InsuranceManagement.Dtos.ClaimsDto;
import com.ayushkumar.InsuranceManagement.Entity.Claims;
import com.ayushkumar.InsuranceManagement.Exceptions.ClaimsDetailsNotFoundException;
import com.ayushkumar.InsuranceManagement.Exceptions.Insurance_policiesNotFoundException;
import com.ayushkumar.InsuranceManagement.Exceptions.InvalidClaimsRequestBodyException;
import com.ayushkumar.InsuranceManagement.Services.ClaimsServices;
import com.ayushkumar.InsuranceManagement.Services.Insurance_policiesServices;
import com.ayushkumar.InsuranceManagement.Validators.ClaimsDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimsController {

    @Autowired
    private ClaimsServices claimsServices;
    @Autowired
    private Insurance_policiesServices insurance_policiesServices;

    //URI -> Post 127.0.0.1:7777/api/claims
    @PostMapping
    public ResponseEntity createClaims(@RequestBody ClaimsDto claimsDto) throws Insurance_policiesNotFoundException, InvalidClaimsRequestBodyException {
        ClaimsDtoValidator.isValid(claimsDto);
        Claims claims=convertToClaims(claimsDto);
        Claims savedClaims=claimsServices.acceptClaimsDetails(claims);
        ClaimsDto claimsDto1=convertToClaimsDto(savedClaims);
        return new ResponseEntity(claimsDto1, HttpStatus.ACCEPTED);
    }

    //URI -> Put 127.0.0.1:7777/api/claims/{id}
    @PutMapping("/{id}")
    public ResponseEntity updateClaims(@PathVariable("id") int id,@RequestBody ClaimsDto claimsDto) throws Insurance_policiesNotFoundException, ClaimsDetailsNotFoundException {
        Claims claims=convertToClaims(claimsDto);
        Claims updatedClaims=claimsServices.updateClaimsDetails(id,claims);
        ClaimsDto claimsDto1=convertToClaimsDto(updatedClaims);
        return new ResponseEntity(claimsDto1,HttpStatus.OK);
    }

    //URI -> Get 127.0.0.1:7777/api/claims/{id}
    @GetMapping("/{id}")
    public ResponseEntity getClaimsById(@PathVariable("id") int id) throws ClaimsDetailsNotFoundException {
        Claims fetchedClaims=claimsServices.getClaimsById(id);
        ClaimsDto claimsDto=convertToClaimsDto(fetchedClaims);
        return new ResponseEntity(claimsDto,HttpStatus.OK);
    }

    //URI -> Get 127.0.0.1:7777/api/claims
    @GetMapping
    public ResponseEntity getAllClaims(){
        List<Claims> claims=claimsServices.getAllClaims();
        List<ClaimsDto> claimsDtos=new ArrayList<>();
        for(int i=0;i<claims.size();i++){
            claimsDtos.add(convertToClaimsDto(claims.get(i)));
        }
        return new ResponseEntity(claimsDtos,HttpStatus.OK);
    }

    //URI -> Delete 127.0.0.1:7777/api/claims/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") int id){
        boolean res=claimsServices.deleteClaimsDetails(id);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    private Claims convertToClaims(ClaimsDto claimsDto) throws Insurance_policiesNotFoundException {
        Claims claims=new Claims(0,claimsDto.getClaim_number(),claimsDto.getDescription(),claimsDto.getClaim_date(),claimsDto.getClaim_status());
        if(claimsDto.getInsurance_policies_id()>0)
            claims.setInsurance_policies(insurance_policiesServices.getInsurance_policiesById(claimsDto.getInsurance_policies_id()));
        return claims;
    }
    private ClaimsDto convertToClaimsDto(Claims claims){
        ClaimsDto claimsDto=new ClaimsDto(claims.getId(),claims.getClaim_number(),claims.getDescription(),claims.getClaim_date(),claims.getClaim_status());
        claimsDto.setInsurance_policies_id(claims.getInsurance_policies().getId());
        return claimsDto;
    }

}
