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

    public void updateDriverLocation(String name, Pair<Float, Float> location) throws NullPointerException {
        try {
            this.drivers.get(name).setLocation(location);
        } catch (NullPointerException e) {
            System.out.println("Driver not found in the database. Should add it as a new driver first.");
            throw e;
        }
    }

    public void changeDriverStatus(String name, boolean status) {
        try {
            this.drivers.get(name).setAvailability(status);
        } catch (NullPointerException e) {
            System.out.println("Driver not found in the database. Should add it as a new driver first.");
            throw e;
        }
    }

}
