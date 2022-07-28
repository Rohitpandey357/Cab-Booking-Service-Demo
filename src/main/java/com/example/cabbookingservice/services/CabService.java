package com.example.cabbookingservice.services;

import java.util.List;

/*
 * A generic interface for the cab booking service so that you can customise it according to your own rules.
 */

public interface CabService<T> {
    public List<T> findRide();
    public void chooseRide();
    public int calculateBill();
}
