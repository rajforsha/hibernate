package com.raj.shashi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LAP")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long laptopId;

    @Column
    private String laptopName;

    public long getLaptopId() {
        return this.laptopId;
    }

    public void setLaptopId(long laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopName() {
        return this.laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    @Override
    public String toString() {
        return "Laptop [laptopId=" + this.laptopId + ", laptopName=" + this.laptopName + "]";
    }

}
