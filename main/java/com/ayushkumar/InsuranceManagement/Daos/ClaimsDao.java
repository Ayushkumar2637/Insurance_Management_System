package com.ayushkumar.InsuranceManagement.Daos;

import com.ayushkumar.InsuranceManagement.Entity.Claims;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimsDao extends JpaRepository<Claims,Integer> {
}
