package com.example.cabbookingservice.models;

import org.springframework.data.util.Pair;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class User extends Person {
    @Getter @Setter private Pair<Float, Float> location;
    User(String name, String gender, int age) {
        super(name, gender, age);
    }
}
