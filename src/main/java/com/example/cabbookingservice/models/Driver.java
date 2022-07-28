package com.example.cabbookingservice.models;

import org.springframework.data.util.Pair;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Driver extends Person{
    @Getter @Setter Vehicle vehicle;
    @Getter @Setter private Pair<Float, Float> location;
    Driver(String name, String gender, int age) {
        super(name, gender, age);
    }
}
