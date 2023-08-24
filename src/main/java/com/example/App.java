package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();


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

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        session.save(student1);
        session.save(student2);
        Student std3=(Student)session.load(Student.class,1);
        System.out.println(std3.getName());
        tx.commit();
        session.close();

        System.out.println("********************************************************");

        Session session1= factory.openSession();
        Student std=(Student)session1.load(Student.class,1);
        System.out.println(std.getName());
        System.out.println("********************************************************");

        Student std2=(Student)session1.get(Student.class,2);
        System.out.println(std2);

        System.out.println("********************************************************");

        Student std1=(Student)session1.load(Student.class,1);

        session1.close();

        factory.close();

    }
}
