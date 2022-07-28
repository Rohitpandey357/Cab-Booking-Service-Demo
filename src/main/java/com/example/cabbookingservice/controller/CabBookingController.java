package com.example.cabbookingservice.controller;

import org.springframework.data.util.Pair;

import com.example.cabbookingservice.models.Driver;
import com.example.cabbookingservice.models.User;
import com.example.cabbookingservice.models.Vehicle;
import com.example.cabbookingservice.modelservices.DriverService;
import com.example.cabbookingservice.modelservices.UserService;
import com.example.cabbookingservice.services.CabServiceImpl;

public class CabBookingController {
    private UserService userService = new UserService();
    private DriverService driverService = new DriverService();
    private CabServiceImpl cabService = new CabServiceImpl();

    public void addUser(String name, String gender, int age) {
        userService.add(new User(name, gender, age));
    }

    public void updateUser(String userName, String updatedContact) {
        userService.updateUser(userName, updatedContact);
    }

    public void updateUserLocation(String userName, Pair<Float, Float> location) {
        userService.updateUserLocation(userName, location);
    }

    public void addDriver(String name, String gender, int age, String vehicleName, String vehicleNumber, Pair<Float, Float> location) {
        Driver driver = new Driver(new Vehicle(vehicleName, vehicleNumber), true, location);
        driver.setAge(age);
        driver.setGender(gender);
        driver.setName(name);
        driverService.add(driver);
    }

    public void updateDriverLocation(String name) {
        driverService.updateDriverLocation(name);
    }

    public void changeDriverStatus(String name, boolean status) {
        driverService.changeDriverStatus(name, status);
    }

    public void findRide(String userName, Pair<Float,Float> source, Pair<Float,Float> destination) {
        cabService.findRide(userName, source, destination, driverService.getDrivers());
    }

    public void chooseRide(String userName, String driverName) {
        cabService.chooseRide(userName, driverName, driverService.getDrivers());
    }

    public void calculateBill(String userName) {
        cabService.calculateBill(userName, driverService.getDrivers(), userService.getUsers());
    }

    public void findTotalEarnings() {
        cabService.findTotalEarnings(driverService.getDrivers());
    }
}
