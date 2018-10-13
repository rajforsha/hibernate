package com.raj.shashi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMP")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long companyId;

    @Column
    private String companyName;

    public long getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company [companyId=" + this.companyId + ", companyName=" + this.companyName + "]";
    }

}
