package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "STUDENT_DETAILS")
public class Details {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private String id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "COURSE", nullable = false, length = 50)
    private String course;

    @Column(name = "GRADE", length = 5)
    private String grade;

    @Column(name = "YEAR_OF_PASS", nullable = false)
    private int yearOfPass;

    @Column(name = "CLG_NAME", length = 200)
    private String clgName;

   
    
    
    public Details() {}

	public Details(String id, String name, String course, String grade, int yearOfPass, String clgName) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.grade = grade;
		this.yearOfPass = yearOfPass;
		this.clgName = clgName;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getYearOfPass() {
		return yearOfPass;
	}

	public void setYearOfPass(int yearOfPass) {
		this.yearOfPass = yearOfPass;
	}

	public String getClgName() {
		return clgName;
	}

	public void setClgName(String clgName) {
		this.clgName = clgName;
	}

	
	

	
}
