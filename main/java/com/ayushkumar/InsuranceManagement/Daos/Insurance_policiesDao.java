package com.ayushkumar.InsuranceManagement.Daos;

import com.ayushkumar.InsuranceManagement.Entity.Insurance_policies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Insurance_policiesDao extends JpaRepository<Insurance_policies,Integer> {
}
