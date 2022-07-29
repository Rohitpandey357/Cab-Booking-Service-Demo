package com.example.cabbookingservice.fileparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.cabbookingservice.controller.CabBookingController;

@ExtendWith(MockitoExtension.class)
public class InputParserTest {
    
    private CabBookingController cabBookingController = Mockito.mock(CabBookingController.class);

    @InjectMocks
    InputParser inputParser = new InputParser();

    @Test
    public void checkInputParserWithNullValue() {
        String input = null;
        try {
            new InputParser().parseInput(input);
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    public void addUserInputParserTest() {
        String input = "add_user(\"Abhishek, M,  23\")";
        inputParser.parseInput(input);
        verify(cabBookingController).addUser(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt());
    }

    @Test
    public void addDriverInputParserTest() {
        String input = "add_driver(\"Driver1,M,22\",\"Swift,KA-01-12345\",(10,1))";
        inputParser.parseInput(input);
        verify(cabBookingController).addDriver(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyString(),
        Mockito.anyString(), Mockito.any());
    }

    @Test
    public void updateUserLocationInputParserTest() {
        String input = "update_userLocation(\"Abhishek\",(0,0))";
        inputParser.parseInput(input);
        verify(cabBookingController).updateUserLocation(Mockito.anyString(), Mockito.any());
    }

    @Test
    public void updateUserInputParserTest() {
        String input = "update_user(\"Abhishek\",\"87463732846\")";
        inputParser.parseInput(input);
        verify(cabBookingController).updateUser(Mockito.anyString(), Mockito.anyString());
    }

    @Test
    public void updateDriverLocationInputParserTest() {
        String input = "update_driverLocation(\"Abhishek\")";
        inputParser.parseInput(input);
        verify(cabBookingController).updateDriverLocation(Mockito.anyString());
    }

    @Test
    public void changeDriverStatusInputParserTest() {
        String input = "change_driver_status(\"Driver1\",False)";
        inputParser.parseInput(input);
        verify(cabBookingController).changeDriverStatus(Mockito.anyString(), Mockito.anyBoolean());
    }

    @Test
    public void findRideInputParserTest() {
        String input = "find_ride(\"Nandini\",(15,6),(20,4))";
        inputParser.parseInput(input);
        verify(cabBookingController).findRide(Mockito.anyString(), Mockito.any(), Mockito.any());
    }    

    @Test
    public void chooseRideInputParserTest() {
        String input = "choose_ride(\"Rahul\",\"Driver1\")";
        inputParser.parseInput(input);
        verify(cabBookingController).chooseRide(Mockito.anyString(), Mockito.anyString());
    } 

    @Test
    public void calculateBillInputParserTest() {
        String input = "calculateBill(\"Rahul\")";
        inputParser.parseInput(input);
        verify(cabBookingController).calculateBill(Mockito.anyString());
    } 

    @Test
    public void findTotalEarningInputParserTest() {
        String input = "find_total_earning()";
        inputParser.parseInput(input);
        verify(cabBookingController).findTotalEarnings();
    } 

    @Test
    public void invalidInputInputParserTest() {
        String input = "invalidInput";
        inputParser.parseInput(input);
        verifyNoInteractions(cabBookingController);
    }

}
