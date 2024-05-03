package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name = "myStudent")            for changing the name of table in database
public class Student {

    @Id
    private int id;

    private String name;
    private String city;

    public Student(int id, String name, String city) {
        super();
        this.id = id;
        this.name = name;
        this.city = city;
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
