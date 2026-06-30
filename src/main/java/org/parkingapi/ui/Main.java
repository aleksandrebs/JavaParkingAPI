package org.parkingapi.ui;

import org.parkingapi.service.ParkingService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //console UI for the parking system
        System.out.println("Hello, please select the number of parking slots: ");
        int totalSlots = input.nextInt();
        ParkingService parkingService = new ParkingService(totalSlots); //creates a new parking service with n slots
        System.out.println("You have successfully created a Parking Service with " + totalSlots + " parking slots.");
        System.out.println("Please select which spot to reserve: ");
        int currResSpot = input.nextInt();

        //asks the user to enter reservation start date and time in the correct format
        System.out.println("Please select the start date for the reservation using the format 'MM-dd': ");
        String currResDate = input.next();
        System.out.println("Please select the start time for the reservation using the format 'HH:mm': ");
        String currResTime = input.next();
        //formats and parses date and time into LocalDateTime variable (automatically adding current year and 00 seconds)
        LocalDateTime startResDnTime = LocalDateTime.parse("2026-" + currResDate + "T"  + currResTime + ":00");

        //asks the user to enter reservation end date and time in the correct format
        System.out.println("Please select the start date for the reservation using the format 'MM-dd': ");
        currResDate = input.next();
        System.out.println("Please select the start time for the reservation using the format 'HH:mm': ");
        currResTime = input.next();
        //formats and parses date and time into LocalDateTime variable (automatically adding current year and 00 seconds)
        LocalDateTime endResDnTime = LocalDateTime.parse("2026-" + currResDate + "T"  + currResTime + ":00");

        parkingService.addReservation(currResSpot, startResDnTime, endResDnTime); //adds the reservation to the parking spot

        input.close();

    }

}
