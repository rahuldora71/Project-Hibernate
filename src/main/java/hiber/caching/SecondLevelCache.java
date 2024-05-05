package hiber.caching;


import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.hibernate.cfg.Configuration;

public class SecondLevelCache {
    public static void main(String[] args) {






        SessionFactory factory=new Configuration().configure().buildSessionFactory();


        Session s1=factory.openSession();
        Student student=s1.get(Student.class,128);
        System.out.println(student.getName());
        s1.close();


        Session s2=factory.openSession();
        Student student2=s2.get(Student.class,128);
        System.out.println(student.getName());
        s2.close();

        factory.close();

    }
}
