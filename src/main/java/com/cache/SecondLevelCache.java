package com.cache;

import com.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCache {
    public static void main(String[] args){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();

        Session session= factory.openSession();

        Student student=session.get(Student.class,1);

        System.out.println(student);
        session.close();

        Session session2 = factory.openSession();
        Student student2=session2.get(Student.class,1);
        System.out.println(student2);
        session2.close();
    }
}




































