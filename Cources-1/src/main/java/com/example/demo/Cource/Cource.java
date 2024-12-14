package com.example.demo.Cource;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cource {
	
	@Id
	private String id;
	private String name;
	private String dur;
	public Cource() {}
	
	public Cource(String id, String name, String dur) {
		this.id = id;
		this.name = name;
		this.dur = dur;
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
	public String getDur() {
		return dur;
	}
	public void setDur(String dur) {
		this.dur = dur;
	}
	@Override
	public String toString() {
		return "Cource [id=" + id + ", name=" + name + ", dur=" + dur + "]";
	}
	

}
