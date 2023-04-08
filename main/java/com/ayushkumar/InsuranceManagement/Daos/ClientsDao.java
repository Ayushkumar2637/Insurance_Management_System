package com.ayushkumar.InsuranceManagement.Daos;

import com.ayushkumar.InsuranceManagement.Entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsDao extends JpaRepository<Clients,Integer> {
}
