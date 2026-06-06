package org.ibgradecalc.ui;

import org.ibgradecalc.service.ParkingService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Hello, please select the number of parking slots: ");
        int totalSlots = input.nextInt();
        ParkingService parkingService = new ParkingService(totalSlots);
        System.out.println("You have successfully created a Parking Service with " + totalSlots + " parking slots.");
        System.out.println(parkingService.getSlots());

        input.close();

    }

}
