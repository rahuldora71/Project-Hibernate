package com.xmlMaping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class XmlMappingDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Person p1=new Person(2,"manoj","panipat","+918957821365");
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        s.save(p1);

        tx.commit();
        s.close();
        factory.close();

    }
}
