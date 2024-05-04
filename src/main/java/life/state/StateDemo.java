package life.state;

import org.example.Certification;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
    public static void main(String[] args) {

        //Practice of hibernate Object States:
        //Transient
        //Persistent
        //Detached
        //Removed

        SessionFactory factory=new Configuration().configure().buildSessionFactory();

        //Create Student class object
        Student student=new Student();
        student.setId(1414);
        student.setName("Peter");
        student.setCity("ABC");
        student.setCertification(new Certification("Java Hibernate Course","12 Month"));
        // Student in Transient State

        Session s= factory.openSession();
        Transaction tx=s.beginTransaction();
        s.save(student);
        //Student in Persistent - session, database
        student.setName("John");

        tx.commit();
        s.close();
        // Detached:
        student.setName("Sachin");
        System.out.println(student.getName());

        factory.close();

    }
}
