package com.ayushkumar.InsuranceManagement.Controllers;

import com.ayushkumar.InsuranceManagement.Dtos.Insurance_policiesDto;
import com.ayushkumar.InsuranceManagement.Entity.Claims;
import com.ayushkumar.InsuranceManagement.Entity.Insurance_policies;
import com.ayushkumar.InsuranceManagement.Exceptions.ClientsDetailsNotFoundException;
import com.ayushkumar.InsuranceManagement.Exceptions.Insurance_policiesNotFoundException;
import com.ayushkumar.InsuranceManagement.Exceptions.InvalidInsurancePolicyRequestBodyException;
import com.ayushkumar.InsuranceManagement.Services.ClientsServices;
import com.ayushkumar.InsuranceManagement.Services.Insurance_policiesServices;
import com.ayushkumar.InsuranceManagement.Validators.Insurance_policiesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/insurance_policies")
public class Insurance_policiesController {

    @Autowired
    private Insurance_policiesServices insurance_policiesServices;
    @Autowired
    private ClientsServices clientsServices;


    //URI -> Post 127.0.0.1:7777/api/insurance_policies
    @PostMapping
    public ResponseEntity createInsurance_policies(@RequestBody Insurance_policiesDto insurance_policiesDto) throws InvalidInsurancePolicyRequestBodyException, ClientsDetailsNotFoundException {
        Insurance_policiesValidator.isValid(insurance_policiesDto);
        Insurance_policies insurance_policies=convertToInsurancePolicy(insurance_policiesDto);
        Insurance_policies savedInsurance=insurance_policiesServices.acceptInsurance_policiesDetails(insurance_policies);
        Insurance_policiesDto insurance_policiesDto1=convertToInsurancePolicyDto(savedInsurance);
        return new ResponseEntity(insurance_policiesDto1, HttpStatus.ACCEPTED);
    }

    //URI -> Put 127.0.0.1:7777/api/insurance_policies/{id}
    @PutMapping("/{id}")
    public ResponseEntity updateInsurance_policies(@PathVariable("id") int id,@RequestBody Insurance_policiesDto insurance_policiesDto) throws ClientsDetailsNotFoundException, Insurance_policiesNotFoundException {
        Insurance_policies insurance_policies=convertToInsurancePolicy(insurance_policiesDto);
        Insurance_policies updatedInsurance=insurance_policiesServices.updateInsurance_policiesDetails(id,insurance_policies);
        Insurance_policiesDto insurance_policiesDto1=convertToInsurancePolicyDto(updatedInsurance);
        return new ResponseEntity(insurance_policiesDto1,HttpStatus.OK);
    }

    //URI -> Get 127.0.0.1:7777/api/insurance_policies/{id}
    @GetMapping("/{id}")
    public ResponseEntity getInsuranceById(@PathVariable("id") int id) throws Insurance_policiesNotFoundException {
        Insurance_policies insurance_policies=insurance_policiesServices.getInsurance_policiesById(id);
        Insurance_policiesDto insurance_policiesDto=convertToInsurancePolicyDto(insurance_policies);
        return new ResponseEntity(insurance_policiesDto,HttpStatus.OK);
    }

    //URI -> Get 127.0.0.1:7777/api/insurance_policies
    @GetMapping
    public ResponseEntity getAllInsurance(){
        List<Insurance_policies> insurance_policies=insurance_policiesServices.getAllInsurance_policies();
        List<Insurance_policiesDto> insurance_policiesDtos=new ArrayList<>();
        for(int i=0;i<insurance_policies.size();i++){
            insurance_policiesDtos.add(convertToInsurancePolicyDto(insurance_policies.get(i)));
        }
        return new ResponseEntity(insurance_policiesDtos,HttpStatus.OK);
    }

    //URI -> Delete 127.0.0.1:7777/api/insurance_policies/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") int id){
        boolean res=insurance_policiesServices.deleteInsurance_policiesDetails(id);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    private Insurance_policies convertToInsurancePolicy(Insurance_policiesDto insurance_policiesDto) throws ClientsDetailsNotFoundException {
        Insurance_policies insurance_policies=new Insurance_policies(0,insurance_policiesDto.getPolicy_number(),insurance_policiesDto.getPolicy_type(),insurance_policiesDto.getCoverage_amount(),insurance_policiesDto.getPremium(),insurance_policiesDto.getStart_date(),insurance_policiesDto.getEnd_date());
        if(insurance_policiesDto.getClients_id()>0) {
            int clientId = insurance_policiesDto.getClients_id();
            insurance_policies.setClients(clientsServices.getClientsById(clientId));
        }
        return insurance_policies;
    }
    private Insurance_policiesDto convertToInsurancePolicyDto(Insurance_policies insurance_policies){
        Insurance_policiesDto insurance_policiesDto=new Insurance_policiesDto(insurance_policies.getId(),insurance_policies.getPolicy_number(),insurance_policies.getPolicy_type(),insurance_policies.getCoverage_amount(),insurance_policies.getPremium(),insurance_policies.getStart_date(),insurance_policies.getEnd_date());
        insurance_policiesDto.setClients_id(insurance_policies.getClients().getId());
        if(insurance_policies.getClaims()!=null){
            List<Integer> insurance_policiesId=new ArrayList<>();
            List<Claims> claims=insurance_policies.getClaims();
            for(int i=0;i<claims.size();i++){
                insurance_policiesId.add(claims.get(i).getId());
            }
            insurance_policiesDto.setClaims_id(insurance_policiesId);
        }
        return insurance_policiesDto;
    }
}
