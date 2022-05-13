package com.ers.repositories;

import com.ers.models.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReimbursementRepositories extends JpaRepository<Reimbursement, Integer> {
    @Query(value="select r.status from reimbursement r where r.reimb_author = ?1", nativeQuery = true)
    Reimbursement findByAuthorId(@Param("reimb_author") int r_author);

    @Query(value="select * from reimbursement r where r.status = ?", nativeQuery = true)
    Reimbursement findByStatus(@Param("status") String status);

    @Query(value = "select * from reimbursement r where r.user_id = ?", nativeQuery = true)
    List<Reimbursement> findByUserId(@Param("user_id") int user_id);



//    @Query(value="select * from reimbursement where user_id = ?1", nativeQuery = true)
//    List<Reimbursement> getReimbByUserId(@Param("user_id") int user_id);




//    Reimbursement getReimbByUserId(int user_id);

//      List<Reimbursement> findAllByStatusId(int statusId);

//@Query(value = "select username from tbl_user u where u.username = ?1", nativeQuery = true)
////@Query("select username from tbl_user u where u.username = :username")
//float findByUsername(@Param("username") String username);

}
