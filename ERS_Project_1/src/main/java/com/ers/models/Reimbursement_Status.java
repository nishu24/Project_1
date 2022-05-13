package com.ers.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class Reimbursement_status displays the ID and name of the status. The status can be PENDING
 * DENY/REJECT OR REASSIGNING IT TO THE EMPLOYEE BACK.
 */
@Entity
@Table(name = "reimbursement_status")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Reimbursement_Status {
    @Id
    @Column(name = "status_id", nullable = false)
    private int status_id;

    @Column(name = "reimb_status")
    private String status;

    /**
     * Setting up the Getter and setter methods for the class objects.
     * @return
     */
    public int getStatus_id() {
        return status_id;
    }
    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
