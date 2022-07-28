package com.example.cabbookingservice.modelservices;

import java.util.Map;

import org.springframework.data.util.Pair;

import com.example.cabbookingservice.models.Driver;

import lombok.Getter;
import lombok.Setter;

public class DriverService implements ModelService<Driver> {
    @Getter @Setter Map<String, Driver> drivers;

    public void add(Driver driver) {
        this.drivers.put(driver.getName(), driver);   
    }

    public Pair<Float, Float> updateDriverLocation(String name) throws NullPointerException {
        try {
            return drivers.get(name).getLocation();
        } catch (NullPointerException e) {
            System.out.println("Driver not found in the database. Should add it as a new driver first.");
            throw e;
        }
    }

    public void changeDriverStatus(String name, boolean status) {
        try {
            drivers.get(name).setAvailable(status);
        } catch (NullPointerException e) {
            System.out.println("Driver not found in the database. Should add it as a new driver first.");
            throw e;
        }
    }

}
