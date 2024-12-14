package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Details;
import com.example.demo.Controller.services.Services;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private Services ser;

    @GetMapping("/hello")
    public String sayHi() {
        return "Hello! This project implements a database connection to Spring Boot and performs operations on it.";
    }


    @GetMapping("/hello/{name}")
    public String greetByName(@PathVariable String name) {
        return "This is implemented by " + name;
    }
    
    @GetMapping("/details")
    public List<Details> getDetails() {
        return ser.getDetails();
    }
    
    @PostMapping("/details")
    public String addDetails(@RequestBody Details det) {
        return ser.addData(det);
    }
    
    @DeleteMapping("/details/{id}")
    public List<Details> deleteDetails(@PathVariable String id) {
        return ser.delete(id);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Details> updateDetails(@PathVariable String id, @RequestBody Details newDetails) {
        Details updatedDetails = ser.updateData(id, newDetails);
        if (updatedDetails != null) {
            return ResponseEntity.ok(updatedDetails);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/end")
    public String end() {
        return "This project demonstrates CRUD operations (Create, Read, Update, Delete) using a database with Spring Boot and RESTful APIs.";
    }

}
