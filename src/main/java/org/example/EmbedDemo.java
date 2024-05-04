package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure();
        SessionFactory factory=configuration.buildSessionFactory();

        Student student=new Student();
        student.setName("Rajesh");
        student.setCity("Jind");
        student.setId(127);
        Certification certification=new Certification();
        certification.setCourse("Hibernate");
        certification.setDuration("4 Months");
        student.setCertification(certification);
        Student student2=new Student();
        student2.setName("Sahil");
        student2.setCity("Safidon");
        student2.setId(128);
        Certification certification2=new Certification();
        certification2.setCourse("Web Developer");
        certification2.setDuration("8 Months");
        student2.setCertification(certification2);

        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
//        Object Save
        session.save(student);
        session.save(student2);



        tx.commit();
        session.close();
        factory.close();
    }
}
