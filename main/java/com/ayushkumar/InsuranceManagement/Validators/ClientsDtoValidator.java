package com.ayushkumar.InsuranceManagement.Validators;

import com.ayushkumar.InsuranceManagement.Dtos.ClientsDto;
import com.ayushkumar.InsuranceManagement.Exceptions.InvalidClientsRequestBodyException;

public class ClientsDtoValidator {
    public static boolean isValid(ClientsDto clientsDto) throws InvalidClientsRequestBodyException {
        if(clientsDto.getName()==null || clientsDto.getName().equals(""))
            throw new InvalidClientsRequestBodyException("Client name is empty or null");
        if(clientsDto.getDate_of_birth()==null)
            throw new InvalidClientsRequestBodyException("Client date of birth is null");
        if(clientsDto.getAddress()==null || clientsDto.getAddress().equals(""))
            throw new InvalidClientsRequestBodyException("Client address is empty or null");
        if(clientsDto.getContact_info()==null || clientsDto.getContact_info().equals(""))
            throw new InvalidClientsRequestBodyException("Client contact info is empty or null");
        return true;
    }
}
