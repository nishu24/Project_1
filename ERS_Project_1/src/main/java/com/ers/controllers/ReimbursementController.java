package com.ers.controllers;


import ch.qos.logback.core.status.Status;
import com.ers.exception.RecordNotFoundException;
import com.ers.models.Login;
import com.ers.models.Reimbursement;
import com.ers.models.Reimbursement_Type;
import com.ers.models.Users;
import com.ers.repositories.LoginRepos;
import com.ers.repositories.ReimbursementRepositories;
import com.ers.services.ReimbursementService;
import com.ers.services.ReimbursementTypeService;
import com.ers.services.UsersService;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static ch.qos.logback.core.status.Status.*;

/**
 * This is the main controller, which controls everything here in the Reimbursement Request System.
 * This main controller can be called on the port; 8081 by request mapping path /reimbursements
 */
@RestController
@RequestMapping("/reimbursements")
public class ReimbursementController {
    /**
     * Autowiring all the objects of the Service class and their respective repositories classes.
     */
    @Autowired
    ReimbursementService reimbursementService;
    @Autowired
    ReimbursementTypeService reimbursementTypeService;
    @Autowired
    UsersService usersService;

    /**
     * This method returns the list of the reimbursements requested. This method fetches all the record
     * for the reimbursements from the database and table named: "reimbursement". The mapping value and path
     * is: /list get mapping.
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<Reimbursement>> getAllReimbursementForEmp() {
        List<Reimbursement> list = reimbursementService.getAllReimbursementForEmp();
        return new ResponseEntity<List<Reimbursement>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     *  Method for viewing single reimbursements by its ID. Reimbursements will have their respective
     *  ID's and here this method returns rid from the reimbursement table.
     * @param rid
     * @return
     * @throws RecordNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<Reimbursement> getReimbursementById(@PathVariable("id") int rid)
            throws RecordNotFoundException {
        Reimbursement entity = reimbursementService.getReimbursementById(rid);
        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    /**
     * This method takes the request mapping, request body in the json format, and updates or submits
     * the reimbursements. This also throws the RecordNotFoundException. This Post Mapping method would basically
     * accepts the new request and woud store it in the database table
     * @param r
     * @return
     * @throws RecordNotFoundException
     */
    @PostMapping
    public ResponseEntity<Reimbursement> createOrUpdateReimbursement(@RequestBody Reimbursement r)
            throws RecordNotFoundException {
        Reimbursement updated = reimbursementService.createOrUpdateReimbursement(r);
        return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * This method deletes a reimbursement request by ID, just grab an ID and delete:Only By Admin side
     * @param rid
     * @return
     * @throws RecordNotFoundException
     */
    // <--ERROR--> Cannot delete or update a parent row: a foreign key constraint fails :( <--ERROR-->
    @DeleteMapping("/{id}")
    public HttpStatus deleteReimbursementById(@PathVariable("id") int rid)
            throws RecordNotFoundException {
        reimbursementService.deleteReimbursementById(rid);
        return HttpStatus.FORBIDDEN;
    }

    /**
     * This method is used to see what kinds of reimbursement types are allowed in this Particular Company
     * CATEGORIES :- 1. Lodging
     *               2. Travel
     *               3.Food
     *               4. Medical
     * @return
     */
    @GetMapping("/categories")   // Worked, No Error :)
    public ResponseEntity<List<Reimbursement_Type>> getAllReimbursementTypes() {
        List<Reimbursement_Type> list = reimbursementTypeService.getAllReimbursementTypesToCheck();
        return new ResponseEntity<List<Reimbursement_Type>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    /**
     * This method grabs the list of all the users from the Users' table in the DB, for admin/Manager
     * to double check. Basically the users can be of two types. 1 is Admin and 2. is for Manager.
     * @return
     */
    @GetMapping("/users/list")
    public ResponseEntity<List<Users>> getAllUsersForAdmin(){
        List<Users> list = usersService.getAllUsersForAdmin();
        return new ResponseEntity<List<Users>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * This method returns the users ID. user_ID is saved and fetched from the users table.
     * @param id
     * @return
     * @throws RecordNotFoundException
     */
    @GetMapping("/users/{id}")   // Worked :)
    public ResponseEntity<Users> getUsersById(@PathVariable("id") int id)
            throws RecordNotFoundException {
        Users entity = usersService.getAllUsersById(id);
        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    // Employee list for Admin based on author
//    @GetMapping(value="/admin/{r_author}")   //
//    public ResponseEntity<Reimbursement> getReimbursementByAuthorId(@PathVariable("r_author") int r_author)
//            throws RecordNotFoundException {
//        Reimbursement entity = reimbursementService.getReimbursementByAuthorId(r_author);
//        return new ResponseEntity<Reimbursement>(entity, new HttpHeaders(), HttpStatus.OK);
//    }
    //"Error-message": "query did not return a unique result: 2; nested exception is

    /**
     * This method is basically used for Approving/Rejecting/Reassigining the reimbursements.
     * With this method can updates the status of the requests. Accepts the request body from the
     * post mapping method in json format and updates it into the database table.
     * @param r
     * @return
     * @throws RecordNotFoundException
     */
    @PostMapping("/admin/update") // DONE - Able to update the status of REIMBURSEMENT
    public ResponseEntity<Reimbursement> changeReimburseStatus(@RequestBody Reimbursement r)
            throws RecordNotFoundException {
        Reimbursement updated = reimbursementService.createOrUpdateReimbursement(r);
        return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    // 1)The [reimbursement_type] property of the [com.ers.models.Reimbursement] entity was modified,
    // but it won't be updated because the property is immutable.
//2) The [reimbursement_status] property of the [com.ers.models.Reimbursement] entity was modified,
// but it won't be updated because the property is immutable.

//    @GetMapping("/admin/{status}")   // Method for grabbing by status "PENDING" / NOT WORKING
//    public ResponseEntity<Reimbursement> getReimbursementByStatus(@PathVariable("status") String status)
//            throws RecordNotFoundException {
//        Reimbursement entity = reimbursementService.getReimbursementByStatus(status);
//        return new ResponseEntity<Reimbursement>(entity, new HttpHeaders(), HttpStatus.OK);
//    }

//    @GetMapping(value="/usersid/{id}") // Not working
//    public ResponseEntity<List<Reimbursement>> getAllByUserId(@PathVariable("user_id") int user_id) {
//        List<Reimbursement> list = null;
//        try {
//            list = reimbursementService.getReimbursementByUserId(user_id);
//        } catch (RecordNotFoundException e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<List<Reimbursement>>(list, new HttpHeaders(), HttpStatus.OK);
//    }
}
