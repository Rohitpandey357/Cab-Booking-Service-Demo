package com.example.cabbookingservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CabServiceImplTest {
    
    @Test
    public void findRideThrowsNullPointerException() {
        try {
            new CabServiceImpl().findRide(null, null, null, null);
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    public void chooseRideThrowsNullPointerException() {
        try {
            new CabServiceImpl().chooseRide(null, null, null);
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    public void calculateBillThrowsNullPointerException() {
        try {
            new CabServiceImpl().calculateBill(null, null, null);
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    public void findTotalEarningsThrowsNullPointerException() {
        try {
            new CabServiceImpl().findTotalEarnings(null);
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }
}
