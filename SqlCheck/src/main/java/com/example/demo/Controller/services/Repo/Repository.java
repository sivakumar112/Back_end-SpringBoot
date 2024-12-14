// Repository.java
package com.example.demo.Controller.services.Repo;



import org.springframework.data.repository.CrudRepository;
import com.example.demo.Details;

public interface Repository extends CrudRepository<Details, String> {

}