package com.ers;

import com.ers.models.Reimbursement;
import com.ers.repositories.ReimbursementRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmpReimburseSystem {
	@Autowired
	ReimbursementRepositories reimbursementRepositories;

	public static void main(String[] args) {
		SpringApplication.run(EmpReimburseSystem.class, args);
	}


}