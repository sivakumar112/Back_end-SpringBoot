package com.example.demo.Details;

import java.util.Map;

public class Details {
    private String id;
    private String name;
    private String course;
    private Map<String, Integer> marks; // Marks in 5 subjects

    public Details() {}

    public Details(String id, String name, String course, Map<String, Integer> marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Details{id='" + id + '\'' + ", name='" + name + '\'' + ", course='" + course + '\'' + ", marks=" + marks + '}';
    }
}