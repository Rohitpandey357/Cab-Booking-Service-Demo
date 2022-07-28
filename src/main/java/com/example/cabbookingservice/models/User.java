package com.example.cabbookingservice.models;

import org.springframework.data.util.Pair;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class User extends Person {
    @Getter @Setter private String contactNumber;
    @Getter @Setter private Pair<Float, Float> location;
    public User(String name, String gender, int age) {
        super(name, gender, age);
    }
}
