package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateHelloWorld {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Message message = new Message();
        message.setId(1);
        message.setText("Hello, Hibernate!");

        session.save(message);
        tx.commit();
        session.close();
        factory.close();

        System.out.println("Data saved successfully!");
    }
}
