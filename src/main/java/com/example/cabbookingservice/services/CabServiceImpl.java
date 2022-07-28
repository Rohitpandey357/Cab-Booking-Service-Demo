package com.example.cabbookingservice.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.util.Pair;

import com.example.cabbookingservice.models.Driver;
import com.example.cabbookingservice.models.User;
import com.example.cabbookingservice.services.pojo.Ride;

public class CabServiceImpl implements CabService<Driver> { 

    private static final String Null = null;
    //Ride will only be available if a driver is within the range of 5 unit distance from user. 
    private final int MAXIMUM_RANGE_FOR_A_DRIVER_TO_BE_AVAILABLE = 5;    
    private final int COST_PER_UNIT_DISTANCE = 10; 

    private Map<String, Integer> earnings = new HashMap<>();
    private Map<String, Ride> rides = new HashMap<>();

    // This function returns distance between user and driver.
    private double distanceBetweenLocations(Pair<Float, Float> location1, Pair<Float, Float> location2) {
        double distanceBwteenUserAndDriver = Math.sqrt(Math.pow(location1.getFirst() - location2.getFirst(), 2) + 
                                    Math.pow(location1.getSecond() - location2.getSecond(), 2));;
        return distanceBwteenUserAndDriver;
    }

    /*
     * This function finds the drivers which are less than 5 unit distance
     * and return a list of all those drivers.
     */
    public List<Driver> findRide(String userName, Pair<Float, Float> source, 
                                    Pair<Float, Float> destination, Map<String, Driver> drivers) {
        
        List<Driver> availableDrivers = new ArrayList<>();
        for (Map.Entry<String, Driver> entry : drivers.entrySet()) {
            if(distanceBetweenLocations(source, entry.getValue().getLocation()) <= MAXIMUM_RANGE_FOR_A_DRIVER_TO_BE_AVAILABLE) {
                availableDrivers.add(entry.getValue());
            }
        }
        rides.put(userName, new Ride(userName, Null, source, destination));
        return availableDrivers;
    }
    
    /**
     * This function checks whether the driver is available and does two things:
     * 1) if driver is available, assigns the driver to user.
     * 2) if driver is unavailable, prints the same.
     * @param userName
     * @param driverName
     * @param drivers
     */
    public void chooseRide(String userName, String driverName, Map<String, Driver> drivers) {
        try {
            if (drivers.get(driverName).getAvailabity() == true) {
                rides.get(userName).setDriverName(driverName);
                System.out.println("Ride Started.");
            } else {
                System.out.println("Driver not available.");
            }
        } catch (NullPointerException e) {
            System.out.println("Driver not found.");
        }
        
    }

    private void updateUserLocation(String userName, Map<String,User> users) {
        users.get(userName).setLocation(rides.get(userName).getDestination());
    }

    private void updateDriverLocation(Ride ride, Map<String, Driver> drivers) {
        drivers.get(ride.getDriverName()).setLocation(ride.getDestination());
    }

    private void addRideEarningToDriverTotalEarning(Ride ride, int bill) {
        if (earnings.containsKey(ride.getDriverName())) {
            earnings.put(ride.getDriverName(), earnings.get(ride.getDriverName()) + bill);
        } else {
            earnings.put(ride.getDriverName(), bill);
        }
    }

    /**
     * This function does two thongs:
     * 1) calculates the bill of a ride.
     * 2) Add the earnings of the ride to driver's total earnings.
     * @param userName
     * @param drivers
     * @param users
     * @returns the total bill of the ride.
     */
    public int calculateBill(String userName, Map<String, Driver> drivers, Map<String, User> users) {
        Double distance = distanceBetweenLocations(rides.get(userName).getSource(), rides.get(userName).getDestination());
        int bill = (int) (distance * COST_PER_UNIT_DISTANCE);
        updateDriverLocation(rides.get(userName), drivers);
        updateUserLocation(userName, users);
        addRideEarningToDriverTotalEarning(rides.get(userName), bill);
        rides.remove(userName);
        return bill;
    }

    public Map<String, Integer> findTotalEarnings() {
        return this.earnings;
    }
    
}
