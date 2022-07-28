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

    public void add(User user) {
        this.users.put(user.getName(), user);  
        System.out.println("User added successfully.");
    }

    public void updateUser(String name, String updatedContact) {
        try {
            this.users.get(name).setContactNumber(updatedContact);
            System.out.println("User updated successfully.");
        } catch (NullPointerException e) {
            // User not found
            System.out.println("User not found in the database. Should add it as a new user first.");
        }
    }

    public void updateUserLocation(String name, Pair<Float, Float> location) {
        try {
            this.users.get(name).setLocation(location);
            System.out.println("User's location set to -> (" + location.getFirst() + "," + location.getSecond() + ")");
        } catch (NullPointerException e) {
            // User not found
            System.out.println("User not found in the database. Should add it as a new user first.");
        }
    }
}
