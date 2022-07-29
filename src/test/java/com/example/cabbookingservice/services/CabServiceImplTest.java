package com.example.cabbookingservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.util.Pair;

import com.example.cabbookingservice.models.Driver;
import com.example.cabbookingservice.models.User;
import com.example.cabbookingservice.models.Vehicle;
import com.example.cabbookingservice.services.pojo.Ride;

@ExtendWith(MockitoExtension.class)
public class CabServiceImplTest {

    private final int COST_PER_UNIT_DISTANCE = 10;
    private final Pair<Float, Float> sourceLocation = Pair.of(0f, 0f);
    private final Pair<Float, Float> destinationLocation = Pair.of(10f, 10f);

    Map<String, User> users = new HashMap<>();
    Map<String, Driver> drivers = new HashMap<>();

    @BeforeEach
    public void init() {
        users = new HashMap<>();
        users.put("Rahul", new User("Rahul", "M", 27));
        drivers = new HashMap<>();
        Driver driver = new Driver(new Vehicle("Swift", "dl1lu7143"), true, Pair.of(2f, 2f));
        driver.setAge(23);
        driver.setName("Rohit");
        driver.setGender("M");
        drivers.put("Rohit", driver);
    }
    
    @Test
    public void findRideThrowsNullPointerException() {
        try {
            new CabServiceImpl().findRide(null, null, null, null);
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    public void findRideWhenARideIsAvailableTest() {  
        List<Driver> availableDrivers = new ArrayList<>();
        CabServiceImpl spyCabServiceImpl = spy(CabServiceImpl.class);
        users.get("Rahul").setLocation(Pair.of(3f, 3f));
        availableDrivers = spyCabServiceImpl.findRide("Rahul", sourceLocation, destinationLocation, drivers);
        assertEquals(1, availableDrivers.size());
    }

    @Test
    public void findRideWhenNoRideIsAvailableTest() {
        List<Driver> availableDrivers = new ArrayList<>();
        CabServiceImpl spyCabServiceImpl = spy(CabServiceImpl.class);
        availableDrivers = spyCabServiceImpl.findRide("Rahul", Pair.of(10f, 10f), destinationLocation, drivers);
        assertEquals(0, availableDrivers.size());
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
    public void chooseRideTestWhenDriverIsAvailable() {
        CabServiceImpl spyCabServiceImpl = spy(CabServiceImpl.class);
        spyCabServiceImpl.getRides().put("Rahul", new Ride("Rahul", null, sourceLocation, destinationLocation));
        spyCabServiceImpl.chooseRide("Rahul", "Rohit", drivers);
        assertEquals("Rohit", spyCabServiceImpl.getRides().get("Rahul").getDriverName());
    }

    @Test
    public void chooseRideTestWhenDriverIsNotAvailable() {
        CabServiceImpl spyCabServiceImpl = spy(CabServiceImpl.class);
        drivers.get("Rohit").setAvailability(false);
        spyCabServiceImpl.getRides().put("Rahul", new Ride("Rahul", null, sourceLocation, destinationLocation));
        spyCabServiceImpl.chooseRide("Rahul", "Rohit", drivers);
        assertNull(spyCabServiceImpl.getRides().get("Rahul").getDriverName());
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
    public void calculateBillTest() {
        CabServiceImpl spyCabServiceImpl = spy(CabServiceImpl.class);
        spyCabServiceImpl.getRides().put("Rahul", new Ride("Rahul", "Rohit", sourceLocation, destinationLocation));
        assertEquals(null, users.get("Rahul").getLocation());
        assertEquals(Pair.of(2f, 2f), drivers.get("Rohit").getLocation());
        int bill = spyCabServiceImpl.calculateBill("Rahul", drivers, users);
        double distance = Math.sqrt(Math.pow(sourceLocation.getFirst() - destinationLocation.getFirst(), 2) + 
        Math.pow(sourceLocation.getSecond() - destinationLocation.getSecond(), 2));
        assertEquals((int) (COST_PER_UNIT_DISTANCE * distance), bill);
        assertEquals(destinationLocation, drivers.get("Rohit").getLocation());
        assertEquals(destinationLocation, users.get("Rahul").getLocation());
        assertEquals(bill, spyCabServiceImpl.getEarnings().get("Rohit"));
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
