package org.parkingapi.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpot {

    //spotID and reservation list
    private int spotID;
    private List<Reservation> reservations = new ArrayList<Reservation>();

    //initialize the ParkingSpot object
    public ParkingSpot(int spotID) {
        this.spotID = spotID;
    }


    //getter setters for SpotID and reservation list
    public int getSpotID(){
        return spotID;
    }

    public void setSpotID(int spotID){
        this.spotID = spotID;
    }

    public List<Reservation> getReservations(){
        return reservations;
    }

    //method to add reservation to a parking spot
    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

}
