package com.example.cabbookingservice.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.util.Pair;

/*
 * A generic interface for the cab booking service so that you can customise it according to your own rules.
 */

public interface CabService<T> {
    public List<T> findRide(String userName, Pair<Float, Float> source, Pair<Float, Float> destination, Map<String, T> drivers);
    public void chooseRide(String userName, String driverName, Map<String, T> drivers);
}
