package com.example.cabbookingservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Getter @Setter private String name;
    @Getter @Setter private String gender;
    @Getter @Setter private int age;
}
