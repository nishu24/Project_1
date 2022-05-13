package com.ers.repositories;

import com.ers.models.Reimbursement_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementTypeRepos extends JpaRepository<Reimbursement_Type, Integer> {
}
