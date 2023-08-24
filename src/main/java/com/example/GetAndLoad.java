package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetAndLoad {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Student student = new Student();
        student.setId(1);
        student.setName("Manasa");
        student.setCity("Hyd");

        Student student1 = new Student();
        student1.setId(2);
        student1.setName("student1");
        student1.setCity("Hyd");

        Student student2 = new Student();
        student2.setId(3);
        student2.setName("student2");
        student2.setCity("Hyd");

        Student student3 = new Student();
        student3.setId(4);
        student3.setName("student3");
        student3.setCity("Hyd");

        Transaction tx = session.beginTransaction();
        session.save(student);
        session.save(student1);
        session.save(student2);
        Student std3=(Student)session.load(Student.class,1);
        System.out.println(std3.getName());
        tx.commit();


        Student student5 = (Student) session.get(Student.class, 1);
        Student student6 = (Student) session.load(Student.class, 1);
        Student student37 = (Student) session.get(Student.class, 1);
        System.out.println(student.getCity());
        System.out.println(student2.getId());
        System.out.println(student3);
        session.close();
    }
}
