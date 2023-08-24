package com.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class TestOneToMany {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

   Author author=new Author();
        author.setId(1);
        author.setName("author1");

        Books book1=new Books();
        book1.setId(1);
        book1.setBookName("book1");
        book1.setAuthor(author);

        Books book2=new Books();
        book2.setId(2);
        book2.setBookName("book2");
        book2.setAuthor(author);

        Books book3=new Books();
        book3.setId(3);
        book3.setBookName("book3");
        book3.setAuthor(author);

        List<Books> booksList=new ArrayList<>();
        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book3);

        author.setBooks(booksList);

        Transaction tx= session.beginTransaction();
        session.save(author);

        session.save(book1);
        session.save(book2);
        session.save(book3);

        tx.commit();

       System.out.println(session.contains(author));
       Author author1 =(Author)session.get(Author.class, 1);
       Author author2 =(Author) session.get(Author.class, 1);
        System.out.println(author1.getName());
        //System.out.println(author1.getId());

//
       System.out.println(author2.getName());
//       System.out.println(author1.getBooks().size());
//
//        session.update(author1);
//
//        Author author2 =(Author) session.get(Author.class, 1);
//        System.out.println(author2.getName());

         session.close();
//        Author author3 =(Author)session.get(Author.class, 1);
//        System.out.println(author3.getName());
    }
}
