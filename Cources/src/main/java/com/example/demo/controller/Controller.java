package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Services.Services;
import com.example.demo.Details.Details;

@RestController
public class Controller {

    @Autowired
    private Services ser;
    
    
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("/hello/{name}")
    public String sayHi(@PathVariable String  name) {
        return "Hello " + name;
    }

    @RequestMapping(method = RequestMethod.POST, value = "signup")
    public String signup(@RequestBody Details details) {
        return ser.add(details);
    }

    @RequestMapping(method = RequestMethod.POST, value = "login")
    public Details login(@RequestParam String id, @RequestParam String name) {
        return ser.verify(id, name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getDetails")
    public Details getDetails() {
        return ser.getDetails();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateDetails")
    public String updateDetails(@RequestBody Details details) {
        return ser.updateDetails(details);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteDetails")
    public String deleteDetails() {
        return ser.deleteDetails();
    }
}
