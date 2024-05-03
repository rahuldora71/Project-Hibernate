package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure();
        SessionFactory factory=configuration.buildSessionFactory();
//        Creating question
        Question question=new Question(1212,"What is java ");
        Answer answer=new Answer(343,"Java ia a programing language");

        Question question2=new Question(242,"What is Collection Framework ");
        Answer answer2=new Answer(344,"API to work with objects in java ");



        question.setAnswer(answer);
        question2.setAnswer(answer2);
        answer.setQuestion(question);
        answer2.setQuestion(question2);
        Session session=factory.openSession();
        Transaction tx= session.beginTransaction();
//      Save
        session.save(question);
        session.save(answer);
        session.save(question2);
        session.save(answer2);


        tx.commit();
//        Fetching
        System.out.println("===================");
        Question q=(Question)session.get(Question.class,1212);
        System.out.println(q.getQuestion() );
        System.out.println(q.getAnswer().getAnswer());
        System.out.println("===================");
        Answer a=(Answer)session.get(Answer.class,344);
        System.out.println(a.getAnswer());
        System.out.println(a.getQuestion().getQuestion());
        System.out.println("===================");


        session.close();
        factory.close();
    }
}
