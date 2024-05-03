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
        student.setName("Vansh");
        student.setCity("Jind");
        student.setId(125);
        Certification certification=new Certification();
        certification.setCourse("Android");
        certification.setDuration("6 Months");
        student.setCertification(certification);
        Student student2=new Student();
        student2.setName("Mohit");
        student2.setCity("Ambala");
        student2.setId(126);
        Certification certification2=new Certification();
        certification2.setCourse("JAva Developer");
        certification2.setDuration("12 Months");
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
