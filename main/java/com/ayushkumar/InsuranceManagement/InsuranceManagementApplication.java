package com.ayushkumar.InsuranceManagement;

import com.ayushkumar.InsuranceManagement.Exceptions.ClaimsDetailsNotFoundException;
import com.ayushkumar.InsuranceManagement.Exceptions.ClientsDetailsNotFoundException;
import com.ayushkumar.InsuranceManagement.Exceptions.Insurance_policiesNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class InsuranceManagementApplication {

	public static void main(String[] args) throws ClientsDetailsNotFoundException, Insurance_policiesNotFoundException, ClaimsDetailsNotFoundException {
		ApplicationContext context=SpringApplication.run(InsuranceManagementApplication.class, args);
	}

}
