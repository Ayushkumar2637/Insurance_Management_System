package com.ayushkumar.InsuranceManagement.Services.Impl;

import com.ayushkumar.InsuranceManagement.Daos.ClientsDao;
import com.ayushkumar.InsuranceManagement.Entity.Clients;
import com.ayushkumar.InsuranceManagement.Exceptions.ClientsDetailsNotFoundException;
import com.ayushkumar.InsuranceManagement.Services.ClientsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class ClientsServicesImpl implements ClientsServices {

    @Autowired
    private ClientsDao clientsDao;

    @Override
    public Clients acceptClientsDetails(Clients clients) {
        return clientsDao.save(clients);
    }

    @Override
    public Clients updateClientsDetails(int id, Clients clients) throws ClientsDetailsNotFoundException {
        // Fetch Client
        Clients fetchClient=clientsDao.findById(id).orElseThrow(()->
                new ClientsDetailsNotFoundException("Client not found for the client id : "+id));
        // Update Client
        if(clients.getName()!=null)
            fetchClient.setName(clients.getName());
        if(clients.getDate_of_birth()!=null)
            fetchClient.setDate_of_birth(clients.getDate_of_birth());
        if(clients.getAddress()!=null)
            fetchClient.setAddress(clients.getAddress());
        if(clients.getContact_info()!=null)
            fetchClient.setContact_info(clients.getContact_info());
        if(clients.getInsurance_policies()!=null)
            fetchClient.setInsurance_policies(clients.getInsurance_policies());
        // Save in db
        return clientsDao.save(fetchClient);
    }

    @Override
    public Clients getClientsById(int id) throws ClientsDetailsNotFoundException {
        Clients fetchClient=clientsDao.findById(id).orElseThrow(()->
                new ClientsDetailsNotFoundException("Client not found for the client id : "+id));
        return fetchClient;
    }

    @Override
    public List<Clients> getAllClients() {
        return clientsDao.findAll();
    }

    @Override
    public boolean deleteClientsDetails(int id) {
        clientsDao.deleteById(id);
        return true;
    }
}
