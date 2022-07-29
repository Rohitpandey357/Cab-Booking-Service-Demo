package com.example.cabbookingservice.modelservices;

import java.util.HashMap;
import java.util.Map;

import com.example.cabbookingservice.models.Driver;

import lombok.Getter;
import lombok.Setter;

public class DriverService implements ModelService<Driver> {
    @Getter @Setter Map<String, Driver> drivers = new HashMap<>();

    public void add(Driver driver) throws NullPointerException {
        try {
            drivers.put(driver.getName(), driver);   
            System.out.println("Driver added successfully.");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void updateDriverLocation(String name) throws NullPointerException {
        try {
            if(drivers.containsKey(name)) {    
                System.out.println(drivers.get(name).getLocation());
            } else {
                System.out.println("Driver not found in the database. Should add it as a new driver first.");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void changeDriverStatus(String name, boolean status) throws NullPointerException {
        try {
            if(drivers.containsKey(name)) {
                drivers.get(name).setAvailability(status);
                System.out.println("Driver's availabitity changed to = " + status);
            } else {
                System.out.println("Driver not found in the database. Should add it as a new driver first.");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

}
