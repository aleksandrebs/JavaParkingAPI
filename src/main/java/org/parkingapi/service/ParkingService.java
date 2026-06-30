package org.parkingapi.service;

import org.parkingapi.model.ParkingSpot;
import org.parkingapi.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ParkingService {

    private Map<Integer, ParkingSpot> slots= new HashMap<Integer, ParkingSpot>(); //HashMap for associating parking spots with numbers

    //initializes the parking service object
    public ParkingService(int totalSlots){
        //for loop to create n parking spots and put them into the slots HashMap
        for (int i = 1; i <= totalSlots; i++){
            slots.put(i, new ParkingSpot(i));
        }
    }

    //method to set a new reservation
    public void setReservation(Reservation reservation, int spotID, LocalDateTime startDate, LocalDateTime endDate){

        reservation = new Reservation(spotID,startDate,endDate);

    }

    //method to add a reservation to a parking spot
    public void addReservation(int spotID, LocalDateTime startDate, LocalDateTime endDate){

        ParkingSpot currSpot = slots.get(spotID); //gets current spot
        List<Reservation> reservations = currSpot.getReservations(); //gets all active reservations for the current slot

        Boolean isOverlapping = false; //boolean to check if there is reservation time overlap

        if(currSpot.getReservations().isEmpty()){ //adds a new reservation if there are no reservations active
            Reservation newReservation = new Reservation(spotID,startDate,endDate);
            currSpot.addReservation(newReservation);
            System.out.println("Reserved!");
        }else{
            //check for overlaps with current reservations
            for(int i = 0; i < currSpot.getReservations().size(); i++){
                if((reservations.get(i).isOverlapping(startDate, endDate))){
                    isOverlapping = true;
                    System.out.println("Overlapping!");
                    break; //breaks the loop if overlap is found
                }

            }
            if(!isOverlapping){
                //if no overlap is found the reservation is added to the parking spot
                Reservation newReservation = new Reservation(spotID,startDate,endDate);
                currSpot.addReservation(newReservation);
                System.out.println("Reserved!");
            }
        }
    }

    //getter setter methods
    public Map<Integer, ParkingSpot> getSlots(){
        return slots;
    }

}
