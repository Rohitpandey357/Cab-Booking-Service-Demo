package com.example.cabbookingservice.modelservices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.util.Pair;

import com.example.cabbookingservice.models.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class UserService implements ModelService<User> {
    @Getter @Setter private Map<String, User> users = new HashMap<>();

    public void add(User user) throws NullPointerException {
        try {
            users.put(user.getName(), user);  
            System.out.println("User added successfully.");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void updateUser(String name, String updatedContact) throws NullPointerException {
        try {
            if(users.containsKey(name)) {
                users.get(name).setContactNumber(updatedContact);
                System.out.println("User updated successfully.");
            } else {
                // User not found
                System.out.println("User not found in the database. Should add it as a new user first.");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void updateUserLocation(String name, Pair<Float, Float> location) throws NullPointerException {
        try {
            if(users.containsKey(name)) {
                users.get(name).setLocation(location);
                System.out.println("User's location set to -> (" + location.getFirst() + "," + location.getSecond() + ")");
            } else {
                // User not found
                System.out.println("User not found in the database. Should add it as a new user first.");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
