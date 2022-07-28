package com.example.cabbookingservice.models;

import org.springframework.data.util.Pair;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class User extends Person {
    
    public User(String name, String gender, int age, Pair<Float, Float> location) {
        super(name, gender, age, location);
    }
}
