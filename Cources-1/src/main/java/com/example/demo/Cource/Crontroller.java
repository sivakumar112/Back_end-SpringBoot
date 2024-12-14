package com.example.demo.Cource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") 
public class Crontroller {

    @Autowired
    private Services service;

    @GetMapping("/hello")
    public String sayHii() {
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/topics")
    public List<Cource> getAllTopics() {
        return service.get();
    }

    @GetMapping("/topics/{id}")
    public Optional<Cource> getTopicById(@PathVariable String id) {
        return service.getTopic(id);
    }

    @PostMapping("/topics")
    public void addTopic(@RequestBody Cource course) {
        service.addTopic(course);
    }

    @PutMapping("/topics/{id}")
    public String updateTopic(@PathVariable String id, @RequestBody Cource course) {
        return service.update(id, course);
    }

    @DeleteMapping("/topics/{id}")
    public String deleteTopic(@PathVariable String id) {
        return service.del(id);
    }
}
