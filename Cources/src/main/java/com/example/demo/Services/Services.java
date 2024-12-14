package com.example.demo.Services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.demo.Details.Details;

@Service
public class Services {

    private HashMap<String, Details> userDatabase = new HashMap<>();
    private boolean isLoggedIn = false;
    private Details currentUser;

    public String add(Details details) {
        if (userDatabase.containsKey(details.getId())) {
            return "User already exists.";
        }
        userDatabase.put(details.getId(), details);
        return "User account created successfully.";
    }

    public Details verify(String id, String name) {
        if (userDatabase.containsKey(id)) {
            Details storedDetails = userDatabase.get(id);
            if (storedDetails.getName().equals(name)) {
                isLoggedIn = true;
                currentUser = storedDetails;
                return storedDetails;
            } else {
                throw new RuntimeException("Invalid name for the given ID.");
            }
        }
        throw new RuntimeException("User does not exist.");
    }

    public Details getDetails() {
        if (isLoggedIn && currentUser != null) {
            return currentUser;
        }
        throw new RuntimeException("User is not logged in.");
    }

    public String updateDetails(Details updatedDetails) {
        if (isLoggedIn && currentUser != null) {
            userDatabase.put(currentUser.getId(), updatedDetails);
            currentUser = updatedDetails;
            return "Details updated successfully.";
        }
        throw new RuntimeException("User is not logged in.");
    }

    public String deleteDetails() {
        if (isLoggedIn && currentUser != null) {
            userDatabase.remove(currentUser.getId());
            currentUser = null;
            isLoggedIn = false;
            return "Details deleted successfully.";
        }
        throw new RuntimeException("User is not logged in.");
    }
}
