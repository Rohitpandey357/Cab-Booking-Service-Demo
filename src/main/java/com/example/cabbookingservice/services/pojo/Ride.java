package com.example.cabbookingservice.services.pojo;

import org.springframework.data.util.Pair;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Ride {
    @Getter @Setter private String userName;
    @Getter @Setter private String DriverName;
    @Getter @Setter private Pair<Float, Float> source;
    @Getter @Setter private Pair<Float, Float> destination;
}
