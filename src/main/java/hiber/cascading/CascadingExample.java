package hiber.cascading;

import com.one_to_many_mapping.Answer1;
import com.one_to_many_mapping.Question1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CascadingExample {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Question1 q1=new Question1(587,"What is Swing  ");
        Answer1 a1=new Answer1(258,"Swing is use fro development  ",q1);
        Answer1 a2=new Answer1(251,"Desktop",q1);
        Answer1 a3=new Answer1(315,"learn Programing",q1);
        List<Answer1>list=new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        q1.setAnswer(list);
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        s.persist(q1);




        tx.commit();
        s.close();
        factory.close();


    }
}
