package com.example.demo.Cource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {
	
	
	@Autowired
	private Repository repo;
	
	
	public List<Cource> get() {
		List<Cource> courses = new ArrayList<>();
	    repo.findAll().forEach(courses::add);
	    return courses;
	}
	
	public void addTopic(Cource cor) {
		repo.save(cor);
	}
	
	
	public Optional<Cource> getTopic(String id) {
		return repo.findById(id);
		
	}
	
	
	
	
	public String update(String id,Cource cor) {
		if(repo.existsById(id)) {
			repo.save(cor);
			return "Topic updated sucessfully";
		}
		return "No Topic Found so Topic added";
	}
	
	
	public String del(String id) {
		repo.deleteById(id);
		return "Topic Deleted";
		
	}

}
