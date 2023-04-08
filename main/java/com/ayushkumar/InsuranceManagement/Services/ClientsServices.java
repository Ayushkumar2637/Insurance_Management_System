package com.ayushkumar.InsuranceManagement.Services;

import com.ayushkumar.InsuranceManagement.Entity.Clients;
import com.ayushkumar.InsuranceManagement.Exceptions.ClientsDetailsNotFoundException;

import java.util.List;

public interface ClientsServices {
    Clients acceptClientsDetails(Clients clients);
    Clients updateClientsDetails(int id,Clients clients) throws ClientsDetailsNotFoundException;
    Clients getClientsById(int id) throws ClientsDetailsNotFoundException;
    List<Clients> getAllClients();
    boolean deleteClientsDetails(int id);
}
