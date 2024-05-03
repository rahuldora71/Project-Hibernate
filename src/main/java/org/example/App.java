package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory factory= cfg.buildSessionFactory();
        Student student=new Student();
        student.setId(102);
        student.setName("Vikrant");
        student.setCity("Panipat");
        System.out.println(student);
//        Creating obj of Address class

        Address address=new Address();
        address.setStreet("Street1");
        address.setStreetCity("Delhi");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(3233.43);

//        Reading image
        FileInputStream fis=new FileInputStream("src/main/java/org/example/WhatsApp.jpg");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        address.setImage(data);

        Session session=factory.openSession();
        Transaction tx= session.beginTransaction();
        session.save(address);
        session.save(student);
        tx.commit();

        System.out.println("Done");

        session.close();
    }
}
