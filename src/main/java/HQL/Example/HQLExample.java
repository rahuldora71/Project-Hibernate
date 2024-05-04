package HQL.Example;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;


public class HQLExample {
    public static void main(String[] args) {

        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session s=factory.openSession();

        //HQL
        //Syntax
        //

//        String query="from Student";          // Without where clause
//        String query="from Student where city = 'Jind'";      //with where and single condition
        String query="from Student where city =:x and certification.course=:n"; //with dynamically define

        Query q=s.createQuery(query);
        q.setParameter("x","Jind");
        q.setParameter("n","Android");

        //Single -(Unique)
        //multiple-list
        List<Student>list=q.list();
        for(Student student: list)
        {
            System.out.println(student.getName()+" : "+student.getCertification().getCourse());
        }

        Transaction tx=s.beginTransaction();
//        Delete query
        Query q2=s.createQuery("delete from Student where city=:c");
        q2.setParameter("c","ABC");
        int i=q2.executeUpdate();
        System.out.println("Deleted : "+i);


//        Update query
        Query q3=s.createQuery("update Student set city=:c where name=:n");
        q3.setParameter("c","Panipat");
        q3.setParameter("n","Vansh");
        int i1=q3.executeUpdate();
        System.out.println("Updated : "+i1);

        tx.commit();
//        How to join table
//        Query q4=s.createQuery("Select q.question, q.questionId a.answer from Question as q INNER JOIN q.answer as a");
        Query q4=s.createQuery("SELECT q.question, q.questionId, a.answer FROM Question q INNER JOIN q.answer a");
        List<Object[]> list2=q4.getResultList();
        for (Object[]arr:list2){
            System.out.println(Arrays.toString(arr));
        }
        s.close();
        factory.close();

    }
}
