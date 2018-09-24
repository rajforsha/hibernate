package com.raj.shashi.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.raj.shashi.domain.Department;
import com.raj.shashi.domain.Employee;
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

        // Employee
        Employee e = new Employee();
        e.setEmpoloyeeName("Shashi");
        e.setDepartment(d);
        e.setProjectList(projectList);

        Session session = sessionFactory.openSession();

        Transaction t = session.beginTransaction();

        session.save(e);

        t.commit();

        sessionFactory.close();
    }

    public static void getEmployee() {

        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();

    }

    public static void main(String[] args) {
        saveEmployee();
    }

}
