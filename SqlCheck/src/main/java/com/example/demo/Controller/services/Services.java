package com.example.demo.Controller.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Details;
import com.example.demo.Controller.services.Repo.Repository;

@Service
public class Services {

    @Autowired
    private Repository repo;

    public List<Details> getDetails() {
        Iterable<Details> detailsIterable = repo.findAll();
        List<Details> detailsList = new ArrayList<>();
        detailsIterable.forEach(detailsList::add);
        return detailsList;
    }

    public String addData(Details det) {
        if (repo.existsById(det.getId())) {
            return "User Already Exists";
        }
        repo.save(det);
        return "Account Created Successfully";
    }

    public Details updateData(String id, Details newDetails) {
        Optional<Details> existingDetails = repo.findById(id);
        if (existingDetails.isPresent()) {
            Details details = existingDetails.get();
            details.setName(newDetails.getName());
            details.setCourse(newDetails.getCourse());
            details.setGrade(newDetails.getGrade());
            details.setYearOfPass(newDetails.getYearOfPass());
            details.setClgName(newDetails.getClgName());
            return repo.save(details);
        }
        return null;
    }

    public List<Details> delete(String id) {
        Optional<Details> detailsOptional = repo.findById(id);
        if (detailsOptional.isPresent()) {
            repo.deleteById(id);
            Iterable<Details> detailsIterable = repo.findAll();
            List<Details> detailsList = new ArrayList<>();
            detailsIterable.forEach(detailsList::add);
            return detailsList;
        }
        return new ArrayList<>();
    }
}
