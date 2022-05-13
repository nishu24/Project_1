package com.ers.repositories;

import com.ers.models.Reimbursement_Status;
import com.ers.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementStatusRepositories extends JpaRepository<Reimbursement_Status,Integer>{
}
