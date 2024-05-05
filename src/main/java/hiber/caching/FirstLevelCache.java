package hiber.caching;

import com.mysql.cj.exceptions.ClosedOnExpiredPasswordException;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCache {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session s=factory.openSession();

        Student student=s.get(Student.class,128);
        System.out.println(student);
        System.out.println("Working Something ...........");

        Student student1=s.get(Student.class,128);  // no query will run to fetch this data
        System.out.println(student1);
        System.out.println(s.contains(student1));
        s.close();
        factory.close();
    }
}
