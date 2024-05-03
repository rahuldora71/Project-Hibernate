package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        Configuration config=new Configuration();
        config.configure();
        SessionFactory factory=config.buildSessionFactory();
        Session session=factory.openSession();
        Student student=(Student) session.get(Student.class,104);
        System.out.println(student);

        Address address=(Address)session.get(Address.class,2);
        System.out.println(address.getImage());





        session.close();
        factory.close();
    }

}
