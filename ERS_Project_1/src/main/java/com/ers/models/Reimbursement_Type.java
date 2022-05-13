package com.ers.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursement_type")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Reimbursement_Type {
    @Id
    @Column(name = "reimb_type_id", nullable = false)
    private int type_id;

    @Column(name = "reimb_type")
    private String reimb_type;

    public String getReimb_type() {
        return reimb_type;
    }

    public void setReimb_type(String reimb_type) {
        this.reimb_type = reimb_type;
    }

    public int getType_id() {
        return type_id;
    }
    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
}
