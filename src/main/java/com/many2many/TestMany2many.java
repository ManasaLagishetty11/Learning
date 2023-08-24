package com.many2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class TestMany2many {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Employee emp1 = new Employee();
        Employee emp2 = new Employee();

        emp1.setId(1);
        emp1.setName("emp1");

        emp2.setId(2);
        emp2.setName("emp2");

        Project prj1 = new Project();
        Project prj2 = new Project();

        prj1.setId(1);
        prj1.setProjectName("prj1");

        prj2.setId(2);
        prj2.setProjectName("prj2");

        List<Project> projectList = new ArrayList<>();
        projectList.add(prj1);
        projectList.add(prj2);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);

        emp1.setProjectList(projectList);
        emp2.setProjectList(projectList);
        prj1.setEmployeeList(employeeList);
        prj2.setEmployeeList(employeeList);

        Transaction tx = session.beginTransaction();

        session.save(emp1);
        session.save(emp2);
        session.save(prj1);
        session.save(prj2);

        tx.commit();

        session.close();

    }
}
