package com.example.cabbookingservice.services;

import java.util.List;
import java.util.Map;

import com.example.cabbookingservice.models.Driver;

public class CabServiceImpl implements CabService<Driver> {

    private final int COST_PER_UNIT_DISTANCE = 2;  

    //Ride will only be available if a driver is within the range of 5 unit distance from user. 
    private final int MAXIMUM_RANGE_FOR_A_RIDE = 5;    

    private Map<String, Integer> earnings;

    public List<Driver> findRide() {
        // TODO Auto-generated method stub
        return null;
    }

    public void chooseRide() {
        // TODO Auto-generated method stub
        
    }

    public int calculateBill() {
        // TODO Auto-generated method stub
        return 0;
    }

    public Map<String, Integer> findTotalEarnings() {
        return this.earnings;
    }
    
}
