package com.ers.services;

import com.ers.models.Reimbursement;
import com.ers.models.Reimbursement_Type;
import com.ers.repositories.ReimbursementTypeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReimbursementTypeService {

    @Autowired
    ReimbursementTypeRepos reimbursementTypeRepos;

    public List<Reimbursement_Type> getAllReimbursementTypesToCheck()
    {
        List<Reimbursement_Type> reimbursementTypeList = reimbursementTypeRepos.findAll();
        if (reimbursementTypeList.size()>0)
        {
            return reimbursementTypeList;
        } else{
            return new ArrayList<>();
        }
    }
}
