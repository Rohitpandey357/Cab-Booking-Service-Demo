package com.example.cabbookingservice.models;

import org.springframework.data.util.Pair;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class User extends Person {
    @Getter @Setter private String contactNumber;
    public User(String name, String gender, int age, Pair<Float, Float> location) {
        super(name, gender, age, location);
    }
}
