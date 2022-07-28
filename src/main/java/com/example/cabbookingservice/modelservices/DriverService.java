package com.example.cabbookingservice.modelservices;

import java.util.HashMap;
import java.util.Map;

import com.example.cabbookingservice.models.Driver;

import lombok.Getter;
import lombok.Setter;

public class DriverService implements ModelService<Driver> {
    @Getter @Setter Map<String, Driver> drivers = new HashMap<>();

    public void add(Driver driver) {
        drivers.put(driver.getName(), driver);   
        System.out.println("Driver added successfully.");
    }

    public void updateDriverLocation(String name) {
        try {
            System.out.println(drivers.get(name).getLocation());
        } catch (NullPointerException e) {
            System.out.println("Driver not found in the database. Should add it as a new driver first.");
        }
    }

    public void changeDriverStatus(String name, boolean status) {
        try {
            drivers.get(name).setAvailability(status);
            System.out.println("Driver's availabitity changed to = " + status);
        } catch (NullPointerException e) {
            System.out.println("Driver not found in the database. Should add it as a new driver first.");
        }
    }

}
