package com.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMappings {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Question question=new Question();
        question.setId(1);
        question.setQuestion("what is java");
        Answer answer=new Answer();
        answer.setId(1);
        answer.setAnswer("it is a programing language");
        question.setAnswer(answer);

        Transaction tx= session.beginTransaction();

        session.save(question);
        session.save(answer);
        tx.commit();

        session.close();
    }

    }
