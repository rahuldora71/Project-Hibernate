package com.one_to_many_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure();
        SessionFactory factory=configuration.buildSessionFactory();
//        Creating question
    /*    Question1 question1 =new Question1();
        question1.setQuestionId(1212);
        question1.setQuestion("What is Java");

        Question1 question2 =new Question1();
        question2.setQuestionId(242);
        question2.setQuestion("What is Collection Framework");

        Answer1 answer1 =new Answer1();
        answer1.setAnswerId(343);
        answer1.setAnswer("Java ia a programing language");
        answer1.setQuestion1(question1);


        Answer1 answer2 =new Answer1();
        answer2.setAnswerId(345);
        answer2.setAnswer("With the help of java we can create software ");
        answer2.setQuestion1(question1);

        Answer1 answer3 =new Answer1();
        answer3.setAnswerId(346);
        answer3.setAnswer("Java has different type of frameworks");
        answer3.setQuestion1(question1);


        Answer1 answer4 =new Answer1();
        answer4.setAnswerId(344);
        answer4.setAnswer("API to work with objects in java ");
        answer4.setQuestion1(question2);

        List<Answer1>list=new ArrayList<>();
        list.add(answer1);
        list.add(answer2);
        list.add(answer3);


        List<Answer1>list1=new ArrayList<>();
        list1.add(answer4);

        question1.setAnswer(list);
        question2.setAnswer(list1);


*/

        Session session=factory.openSession();
        Transaction tx= session.beginTransaction();
//      Save
        /*session.save(question1);
        session.save(question2);
        session.save(answer1);
        session.save(answer2);
        session.save(answer3);
        session.save(answer4);*/



        tx.commit();
////        Fetching
        System.out.println("===================");
        Question1 q=(Question1)session.get(Question1.class,1212);
        System.out.println(q.getQuestion() );
        for (Answer1 a: q.getAnswer()){
            System.out.println(a.getAnswer());
        }
        System.out.println("===================");


        session.close();
        factory.close();
    }
}
