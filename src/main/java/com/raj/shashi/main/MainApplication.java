package com.raj.shashi.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.raj.shashi.domain.Company;
import com.raj.shashi.domain.Department;
import com.raj.shashi.domain.Employee;
import com.raj.shashi.domain.Laptop;
import com.raj.shashi.domain.Project;

/**
 * <p>
 * An Employee can have one department and can work on multiple projects
 * Employee -- deptartment one to one Employee --- projects one to many
 * </p>
 *
 * @author setup
 *
 */
public class MainApplication {

    public static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }


    public static void saveEmployee() {

        // department
        Department d = new Department();
        d.setDepartmentName("IS");

        // projects

        List<Project> projectList = new ArrayList<>();
        Project p1 = new Project();
        p1.setProjectLocation("Bangalore");
        p1.setProjectName("Spring MVC");

        Project p2 = new Project();
        p2.setProjectLocation("Mysore");
        p2.setProjectName("Spring Boot");

        projectList.add(p1);
        projectList.add(p2);

        Company company = new Company();
        company.setCompanyName("SAP");

        List<Laptop> lapList = new ArrayList<>();
        Laptop laptop1 = new Laptop();
        laptop1.setLaptopName("MAC");

        Laptop laptop2 = new Laptop();
        laptop2.setLaptopName("HP");

        lapList.add(laptop1);
        lapList.add(laptop2);

        // Employee
        Employee e = new Employee();
        e.setEmpoloyeeName("Shashi");
        e.setDepartment(d);
        e.setProjectList(projectList);
        e.setCompany(company);
        e.setLaptop(lapList);

        Session session = sessionFactory.openSession();

        Transaction t = session.beginTransaction();

        session.save(e);

        t.commit();

        session.close();

       // sessionFactory.close();
    }

    public static void getEmployee() {

        Session session = sessionFactory.openSession();
        Query<Employee> query=session.createQuery("From Employee");
        List<Employee> list=query.list();
        list.forEach(val->{
            System.out.println(val);
        });

    }

    public static void main(String[] args) {
        saveEmployee();
        getEmployee();
    }

}
