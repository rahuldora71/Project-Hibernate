package com.many_to_many_mapping;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Emp {
    @Id
    private int eId;
    private String name;
    @ManyToMany
    @JoinTable
            (
                    name = "emp_learn",
                    joinColumns = {@JoinColumn(name = "eid")},
                    inverseJoinColumns = {@JoinColumn(name = "pid")}
            )
    private List<Project> projects;

    public Emp() {
    }

    public Emp(int eId, String name, List<Project> projects) {
        this.eId = eId;
        this.name = name;
        this.projects = projects;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
