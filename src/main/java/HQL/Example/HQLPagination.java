package HQL.Example;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPagination {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session s=factory.openSession();
        Query query=s.createQuery("from Student order by id DESC ");

        // implementing pagination using hibernate
        query.setFirstResult(10);
        query.setMaxResults(15);
        List<Student> list=query.list();
        for (Student st:list)
        {
            System.out.println(st.getId()+" || "+st.getName()+" || "+st.getCity()+" || "+st.getCertification().getCourse()+" || "+st.getCertification().getDuration());
        }


        s.close();
        factory.close();
    }
}
