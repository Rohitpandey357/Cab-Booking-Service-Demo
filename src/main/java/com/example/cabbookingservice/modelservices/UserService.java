package com.example.cabbookingservice.modelservices;

import java.util.Map;

import org.springframework.data.util.Pair;

import com.example.cabbookingservice.models.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class UserService implements ModelService<User> {
    @Getter @Setter private Map<String, User> users;

    public void add(User user) {
        this.users.put(user.getName(), user);  
    }

    public void updateUser(String name, User newDetails) throws NullPointerException {
        try {
            this.users.get(name).setAge(newDetails.getAge());
            this.users.get(name).setGender(newDetails.getGender());
            this.users.get(name).setLocation(newDetails.getLocation());
            this.users.get(name).setName(newDetails.getName());
        } catch (NullPointerException e) {
            // User not found
            System.out.println("User not found in the database. Should add it as a new user first.");
            throw e;
        }
    }

    public void updateUserLocation(String name, Pair<Float, Float> location) throws NullPointerException {
        try {
            this.users.get(name).setLocation(location);
        } catch (NullPointerException e) {
            // User not found
            System.out.println("User not found in the database. Should add it as a new user first.");
            throw e;
        }
    }
}
