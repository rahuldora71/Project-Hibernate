package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory factory= cfg.buildSessionFactory();
        Student student=new Student();
        student.setId(102);
        student.setName("Vikrant");
        student.setCity("Panipat");
        System.out.println(student);
        Session session=factory.openSession();
        Transaction tx= session.beginTransaction();

        session.save(student);
        tx.commit();


        session.close();
    }
}
