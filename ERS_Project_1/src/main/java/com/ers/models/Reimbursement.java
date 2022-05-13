package com.ers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Table(name = "reimbursement")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Reimbursement {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reimb_id", nullable = false)
    private int rid;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String description;

    @Column(name = "status")   // <--- added if code doesn't works
    private String status;

    @Column(name = "reimb_author")
    private int r_author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="reimb_author", updatable = false, insertable = false)
    private UserRoles userRoles;

    @Column(name = "user_id")
    private int user_id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", updatable = false, insertable = false)
    private Users users;

    @Column(name = "reimb_type_id")
    private int r_type_id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // <--- added if code doesn't works
    @JoinColumn(name="reimb_type_id",updatable = false, insertable = false)
    private Reimbursement_Type reimbursement_type;

    /**
     * This is the all arguments constructor, which has all the fields as it's parameters.
     * @param rid - an unique ID for the Reimbursements table enoted by rid.
     * @param amount - displays the amount in double format, which basically displays total amount requested
     * @param description - This string constraint stands as description which describes the reimbursements
     * @param status - shows the status of the reimbursements, Approved / Deny / Re-assign
     * @param r_author - this constraint shows the type of author, whether 2 for Employee & 1 for Manager
     * @param r_type_id - This is the ID of the reimbursement type, where we have 4 types of reimbursement types
     * @param user_id - This stands for the unique ID from the Users table, which has username & password
     */
    public Reimbursement(int rid, double amount, String description, String status, int r_author, int r_type_id, int user_id) {
        this.rid=rid;
        this.amount=amount;
        this.description=description;
        this.status=status;
        this.r_author=r_author;
        this.r_type_id=r_type_id;
        this.user_id=user_id;
    }

    /**
     * Getter method for the User ID, integer format.
     * @return
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * This is the setter method for the user ID
     * @param user_id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * Getter method for getting the reimbursement ID
     * @return
     */
    public int getRid() {
        return rid;
    }

    /**
     * Setter method for the Reimbursement ID
     * @param rid
     */
    public void setRid(int rid) {
        this.rid = rid;
    }

    /**
     * Getter method for the Amount, from the database
     * @return
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter method for the amount
     * @param amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getR_author() {
        return r_author;
    }

    public void setR_author(int r_author) {
        this.r_author = r_author;
    }

    public UserRoles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getR_type_id() {
        return r_type_id;
    }

    public void setR_type_id(int r_type_id) {
        this.r_type_id = r_type_id;
    }

    public Reimbursement_Type getReimbursement_type() {
        return reimbursement_type;
    }

    public void setReimbursement_type(Reimbursement_Type reimbursement_type) {
        this.reimbursement_type = reimbursement_type;
    }

    //    public Reimbursement_Status getReimbursement_status() {
//        return reimbursement_status;
//    }
//
//    public void setReimbursement_status(Reimbursement_Status reimbursement_status) {
//        this.reimbursement_status = reimbursement_status;
//    }

    /**
     * To String methods for all the parameters in the Reimbursement class.
     * @return
     */
    @Override
    public String toString() {
        return "Reimbursement{" +
                "rid=" + rid +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", r_author=" + r_author +
                ", userRoles=" + userRoles +
                ", status='" + status + '\'' +
                ", user_id=" + user_id +
                ", r_type_id=" + r_type_id +
                ", reimbursement_type=" + reimbursement_type +
                '}';
    }
}
