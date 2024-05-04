package com.many_to_many_mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Project {
    @Id
    private int pId;
    @Column(name = "project_name")
    private String projectName;
    @ManyToMany (mappedBy = "projects")
    private List<Emp> emps;

    public Project() {
    }

    public Project(int pId, String projectName, List<Emp> emps) {
        this.pId = pId;
        this.projectName = projectName;
        this.emps = emps;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}
