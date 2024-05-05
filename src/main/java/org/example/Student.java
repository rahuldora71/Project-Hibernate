package org.example;

import org.hibernate.annotations.Cache;
import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
//@Table(name = "myStudent")            for changing the name of table in database
public class Student {

    @Id
    private int id;

    private String name;
    private String city;
    private Certification certification;

    public Student(int id, String name, String city, Certification certification) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.certification = certification;
    }

    public Student(int id, String name, String city) {
        super();
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    public Student() {
        super();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id+" : "+this.name+" : "+this.city;
    }
}
