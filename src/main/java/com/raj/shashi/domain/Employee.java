package com.raj.shashi.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "EMP")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String empoloyeeName;

    public Employee() {

    }

    @OneToOne
    private Department department;

    @OneToMany
    private List<Project> projectList;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpoloyeeName() {
        return this.empoloyeeName;
    }

    public void setEmpoloyeeName(String empoloyeeName) {
        this.empoloyeeName = empoloyeeName;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjectList() {
        return this.projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public String toString() {
        return "Employee [id=" + this.id + ", empoloyeeName=" + this.empoloyeeName + ", department=" + this.department
                + "]";
    }

}