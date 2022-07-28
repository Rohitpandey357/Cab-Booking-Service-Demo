package com.example.cabbookingservice.fileparser;

import org.springframework.data.util.Pair;

import com.example.cabbookingservice.controller.CabBookingController;

public class InputParser {
    private final CabBookingController cabBookingController = new CabBookingController();

    public void parseInput(String input) {
        if (input.length() == 0) {
            return;
        }

        try {
            input = input.replaceAll(" ", "");
            if(input.split("\"")[0].substring(0, input.split("\"")[0].length() - 1).equals("add_user")) {
                String name = input.split("\"")[1].split(",")[0];
                String gender = input.split("\"")[1].split(",")[1];
                int age = Integer.parseInt(input.split("\"")[1].split(",")[2]);
                cabBookingController.addUser(name, gender, age);
            } else if (input.split("\"")[0].substring(0, input.split("\"")[0].length() - 1).equals("add_driver")) {
                String name = input.split("\"")[1].split(",")[0];
                String gender = input.split("\"")[1].split(",")[1];
                int age = Integer.parseInt(input.split("\"")[1].split(",")[2]);
                String vehicleName = input.split("\"")[3].split(",")[0];
                String vehicleNumber = input.split("\"")[3].split(",")[1];
                Float X = Float.parseFloat(input.split(",")[5].substring(1));
                Float Y = Float.parseFloat(input.split(",")[6].substring(0, input.split(",")[6].length() - 2));
                cabBookingController.addDriver(name, gender, age, vehicleName, vehicleNumber, Pair.of(X, Y));
            } else if (input.split("\"")[0].substring(0, input.split("\"")[0].length() - 1).equals("update_userLocation")) {
                String userName = input.split("\"")[1];
                String commaSplit[] = input.split(",");
                Float X = Float.parseFloat(commaSplit[1].substring(1));
                Float Y = Float.parseFloat(commaSplit[2].substring(0, commaSplit[2].length() - 2));
                cabBookingController.updateUserLocation(userName, Pair.of(X, Y));
            } else if (input.split("\"")[0].substring(0, input.split("\"")[0].length() - 1).equals("update_user")) {
                cabBookingController.updateUser(input.split("\"")[1], input.split("\"")[3]);
            } else if (input.split("\"")[0].substring(0, input.split("\"")[0].length() - 1).equals("update_driverLocation")) {
                cabBookingController.updateDriverLocation(input.split("\"")[1]);
            } else if (input.split("\"")[0].substring(0, input.split("\"")[0].length() - 1).equals("change_driver_status")) {
                cabBookingController.changeDriverStatus(input.split("\"")[1], Boolean.parseBoolean(input.split("\"")[2].substring(1,input.split("\"")[2].length() - 1)));
            } else if (input.split("\"")[0].substring(0, input.split("\"")[0].length() - 1).equals("find_ride")) {
                String userName = input.split("\"")[1];
                String commaSplitString[] = input.split(",");
                Float X1 = Float.parseFloat(commaSplitString[1].substring(1));
                Float Y1 = Float.parseFloat(commaSplitString[2].substring(0, commaSplitString[2].length() - 1));
                Float X2 = Float.parseFloat(commaSplitString[3].substring(1));
                Float Y2 = Float.parseFloat(commaSplitString[4].substring(0, commaSplitString[4].length() - 2));
                cabBookingController.findRide(userName, Pair.of(X1, Y1), Pair.of(X2, Y2));
            } else if (input.split("\"")[0].substring(0, input.split("\"")[0].length() - 1).equals("choose_ride")) {
                cabBookingController.chooseRide(input.split("\"")[1], input.split("\"")[3]);
            } else if (input.split("\"")[0].substring(0, input.split("\"")[0].length() - 1).equals("calculateBill")) {
                cabBookingController.calculateBill(input.split("\"")[1]);
            } else if (input.equals("find_total_earning()")) {
                cabBookingController.findTotalEarnings();
            } else {   
                System.out.println("Invalid input.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input -> " + input);
            e.printStackTrace();
        }
    }
}
