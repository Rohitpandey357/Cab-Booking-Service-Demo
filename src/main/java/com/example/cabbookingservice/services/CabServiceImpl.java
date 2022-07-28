package com.example.cabbookingservice.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.util.Pair;

import com.example.cabbookingservice.models.Driver;

public class CabServiceImpl implements CabService<Driver> { 

    //Ride will only be available if a driver is within the range of 5 unit distance from user. 
    private final int MAXIMUM_RANGE_FOR_A_DRIVER_TO_BE_AVAILABLE = 5;    
    private final int COST_PER_UNIT_DISTANCE = 2; 

    private Map<String, Integer> earnings = new HashMap<>();
    private Map<String, String> rides = new HashMap<>(); 
    private Map<String, Pair<Float, Float>> userDestinationLocation = new HashMap<>(); 

    // This function checks whether the driver is within the permissible range from the user.
    private boolean isDriverInRange(Pair<Float, Float> userLocation, Pair<Float, Float> driverLocation) {
        double distanceBwteenUserAndDriver = Math.sqrt(Math.pow(driverLocation.getFirst() - userLocation.getFirst(), 2) + 
                                    Math.pow(driverLocation.getSecond() - userLocation.getSecond(), 2));;
        return distanceBwteenUserAndDriver <= MAXIMUM_RANGE_FOR_A_DRIVER_TO_BE_AVAILABLE;
    }

    public List<Driver> findRide(String userName, Pair<Float, Float> source, 
                                    Pair<Float, Float> destination, Map<String, Driver> drivers) {
        
        List<Driver> availableDrivers = new ArrayList<>();
        for (Map.Entry<String, Driver> entry : drivers.entrySet()) {
            if(isDriverInRange(source, entry.getValue().getLocation())) {
                availableDrivers.add(entry.getValue());
            }
        }
        userDestinationLocation.put(userName, destination);
        return availableDrivers;
    }

    public void chooseRide(String userName, String driverName, Map<String, Driver> drivers) {
        // TODO Auto-generated method stub
        if (drivers.get(driverName).getAvailabity() == true) {
            
        }
    }

    public int calculateBill() {
        // TODO Auto-generated method stub
        return 0;
    }

    public Map<String, Integer> findTotalEarnings() {
        return this.earnings;
    }
    
}
