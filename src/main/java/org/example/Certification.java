package org.example;

import jakarta.persistence.Embeddable;


@Embeddable
public class Certification {
    private String course;
    private String duration;

    public Certification() {
        super();
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Certification(String course, String duration) {
        super();
        this.course = course;
        this.duration = duration;
    }
}
