package com.ers.services;

import com.ers.exception.RecordNotFoundException;
import com.ers.models.Reimbursement;
import com.ers.repositories.ReimbursementRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReimbursementService {
    @Autowired
    ReimbursementRepositories reimbursementRepositories;

    /**
     * This method gets the list of all the reimbursements
     * @return
     */
    public List<Reimbursement> getAllReimbursementForEmp() {
        List<Reimbursement> reimbursementList = reimbursementRepositories.findAll();
        if (reimbursementList.size() > 0) {
            return reimbursementList;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * This method gets the reimbursement by its unique ID.
     * Which is denoted by rid, in the integer format.
     * @param rid
     * @return
     * @throws RecordNotFoundException
     */
    public Reimbursement getReimbursementById(int rid) throws RecordNotFoundException {
        Optional<Reimbursement> reimbursement = reimbursementRepositories.findById(rid);
        if (reimbursement.isPresent()) {
            return reimbursement.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    /**
     * Method for creating the new Reimbursement requests, Fill only field values of Reimbursement table
     *
     * @param re
     * @return
     * @throws RecordNotFoundException
     */
    public Reimbursement createOrUpdateReimbursement(Reimbursement re) throws RecordNotFoundException {
        Optional<Reimbursement> reimbursement = reimbursementRepositories.findById(re.getRid());

        if (reimbursement.isPresent()) {
            Reimbursement newEntity = reimbursement.get();
            newEntity.setAmount(re.getAmount());
            newEntity.setDescription(re.getDescription());
            newEntity.setR_author(re.getR_author());
            newEntity.setStatus(re.getStatus());
            newEntity.setUser_id(re.getUser_id());
            newEntity.setR_type_id(re.getR_type_id());

            newEntity = reimbursementRepositories.save(newEntity);
            return newEntity;
        } else {
            re = reimbursementRepositories.save(re);
            return re;
        }
    }

    /**
     * This method is for deleting the reimbursement requests, from the database table
     * @param rid
     * @throws RecordNotFoundException
     */
    public void deleteReimbursementById(int rid) throws RecordNotFoundException {
        Optional<Reimbursement> reimbursement = reimbursementRepositories.findById(rid);
        if (reimbursement.isPresent()) {
            reimbursementRepositories.deleteById(rid);
        } else {
            throw new RecordNotFoundException("No Reimbursement record found for this given ID");
        }
    }

    /**
     *
     * @param r_author
     * @return
     * @throws RecordNotFoundException
     */
    public Reimbursement getReimbursementByAuthorId(int r_author) throws RecordNotFoundException {
        Reimbursement reimbursement = reimbursementRepositories.findByAuthorId(r_author);
            return reimbursementRepositories.findByAuthorId(r_author);
    }

    /**
     * This method gets the reimbursements by its status
     * @param status
     * @return
     * @throws RecordNotFoundException
     */
    public Reimbursement getReimbursementByStatus(String status) throws RecordNotFoundException {
        Reimbursement reimbursement = reimbursementRepositories.findByStatus(status);
        return reimbursementRepositories.findByStatus(status);
    }

    /**
     * This method returns the List of reimbursements by its respective user id.
     * @param user_id
     * @return
     * @throws RecordNotFoundException
     */
    public List<Reimbursement> getReimbursementByUserId(int user_id) throws RecordNotFoundException{
        List<Reimbursement> reimbursementList = reimbursementRepositories.findByUserId(user_id);
        if (reimbursementList.size() > 0){
            return reimbursementList;
        }else{
            return new ArrayList<>();
        }
    }
//    public List<Reimbursement> getAllReimbursementForEmp() {
//        List<Reimbursement> reimbursementList = reimbursementRepositories.findAll();
//        if (reimbursementList.size() > 0) {
//            return reimbursementList;
//        } else {
//            return new ArrayList<>();
//        }
//    }
//
//    public List<Reimbursement> getAllReimbursementForEmp() {
//        List<Reimbursement> reimbursementList = reimbursementRepositories.findAll();
//        if (reimbursementList.size() > 0) {
//            return reimbursementList;
//        } else {
//            return new ArrayList<>();
//        }
//    }



}
