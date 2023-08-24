package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbaddableEx {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Student student = new Student();
        student.setId(1);
        student.setName("Manasa");
        student.setCity("mncl");
        School school = new School();
        school.setSchoolName("school1");
        school.setArea("area1");
        student.setSchool(school);
        Transaction tx = session.beginTransaction();
        session.save(student);


        tx.commit();
        session.close();

        Session session1 = factory.openSession();
        Student  std=(Student)session1.get(Student.class,1);
        System.out.println(std);
        session1.close();
    }

    }
