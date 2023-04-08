package com.ayushkumar.InsuranceManagement.Controllers;

import com.ayushkumar.InsuranceManagement.Dtos.ClientsDto;
import com.ayushkumar.InsuranceManagement.Entity.Clients;
import com.ayushkumar.InsuranceManagement.Entity.Insurance_policies;
import com.ayushkumar.InsuranceManagement.Exceptions.ClientsDetailsNotFoundException;
import com.ayushkumar.InsuranceManagement.Exceptions.InvalidClientsRequestBodyException;
import com.ayushkumar.InsuranceManagement.Services.ClientsServices;
import com.ayushkumar.InsuranceManagement.Services.Insurance_policiesServices;
import com.ayushkumar.InsuranceManagement.Validators.ClientsDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientsServices clientsServices;

    //URI -> Post 127.0.0.1:7777/api/clients
    @PostMapping
    public ResponseEntity createClients(@RequestBody ClientsDto clientsDto) throws InvalidClientsRequestBodyException {
        ClientsDtoValidator.isValid(clientsDto);
        Clients clients=convertToClients(clientsDto);
        Clients savedClients=clientsServices.acceptClientsDetails(clients);
        ClientsDto clientsDto1=convertToClientsDto(savedClients);
        return new ResponseEntity(clientsDto1, HttpStatus.ACCEPTED);
    }

    //URI -> Put 127.0.0.1:7777/api/clients/{id}
    @PutMapping("/{id}")
    public ResponseEntity updateClaims(@PathVariable("id") int id,@RequestBody ClientsDto clientsDto) throws ClientsDetailsNotFoundException {
        Clients clients=convertToClients(clientsDto);
        Clients updatedClient=clientsServices.updateClientsDetails(id,clients);
        ClientsDto clientsDto1=convertToClientsDto(updatedClient);
        return new ResponseEntity(clientsDto1,HttpStatus.OK);
    }

    //URI -> Get 127.0.0.1:7777/api/clients/{id}
    @GetMapping("/{id}")
    public ResponseEntity getClientById(@PathVariable("id") int id) throws ClientsDetailsNotFoundException {
        Clients clients=clientsServices.getClientsById(id);
        ClientsDto clientsDto=convertToClientsDto(clients);
        return new ResponseEntity(clientsDto,HttpStatus.OK);
    }

    //URI -> Get 127.0.0.1:7777/api/clients
    @GetMapping
    public ResponseEntity getAllClients(){
        List<ClientsDto> clientsDtos=new ArrayList<>();
        List<Clients> clients=clientsServices.getAllClients();
        for(int i=0;i<clients.size();i++){
            clientsDtos.add(convertToClientsDto(clients.get(i)));
        }
        return new ResponseEntity(clientsDtos,HttpStatus.OK);
    }

    //URI -> Delete 127.0.0.1:7777/api/clients/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") int id){
        boolean res=clientsServices.deleteClientsDetails(id);
        return new ResponseEntity(res,HttpStatus.OK);
    }

    private Clients convertToClients(ClientsDto clientsDto){
        Clients clients=new Clients(0,clientsDto.getName(),clientsDto.getDate_of_birth(),clientsDto.getAddress(),clientsDto.getContact_info());
        return clients;
    }
    private ClientsDto convertToClientsDto(Clients clients){
        ClientsDto clientsDto=new ClientsDto(clients.getId(),clients.getName(),clients.getDate_of_birth(),clients.getAddress(),clients.getContact_info());
        if(clients.getInsurance_policies()!=null) {
            List<Integer> insurance_policies_id = new ArrayList<>();
            List<Insurance_policies> insurance_policies = clients.getInsurance_policies();
            for (int i = 0; i < insurance_policies.size(); i++) {
                Insurance_policies ip = insurance_policies.get(i);
                insurance_policies_id.add(ip.getId());
            }
            clientsDto.setInsurance_policies_id(insurance_policies_id);
        }
        return clientsDto;
    }
}
