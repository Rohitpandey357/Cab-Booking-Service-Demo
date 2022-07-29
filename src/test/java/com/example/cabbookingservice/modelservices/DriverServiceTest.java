package com.example.cabbookingservice.modelservices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.util.Pair;

import com.example.cabbookingservice.models.Driver;
import com.example.cabbookingservice.models.Vehicle;

@ExtendWith(MockitoExtension.class)
public class DriverServiceTest {
    
    Driver driver;

    @BeforeEach
    public void init() {
        driver = new Driver(new Vehicle("Swift", "DL1LU7143"), true, Pair.of(10f, 10f));
        driver.setAge(23);
        driver.setGender("M");
        driver.setName("Rahul");     
    }

    @Test 
    public void addThrowsNullPointerException() {
        Driver driver = null;
        try {
            new DriverService().add(driver);
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    public void addDriverTest() {
        DriverService spyDriverService = spy(DriverService.class);
        assertEquals(0, spyDriverService.getDrivers().size());
        spyDriverService.add(driver);
        assertEquals(1, spyDriverService.getDrivers().size());
        assertEquals(driver, spyDriverService.getDrivers().get("Rahul"));
    }

    @Test
    public void updateDriverLocationThrowsNullPointerException() {
        String name = null;
        try {
            new DriverService().updateDriverLocation(name);
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    public void changeDriverStatusThrowsNullPointerException() {
        String name = null;
        try {
            new DriverService().changeDriverStatus(name, true);
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    public void changeDriverStatusTest() {
        DriverService spyDriverService = spy(DriverService.class);
        spyDriverService.getDrivers().put("Rahul", driver);
        assertTrue(spyDriverService.getDrivers().get("Rahul").getAvailabity());
        spyDriverService.changeDriverStatus("Rahul", false);
        assertFalse(spyDriverService.getDrivers().get("Rahul").getAvailabity());
    }

}
