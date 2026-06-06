package org.parkingapi.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpot {

    private int spotID;
    private List<Reservation> reservations = new ArrayList<Reservation>();

    public ParkingSpot(int spotID) {
        this.spotID = spotID;
    }

    public int getSpotID(){
        return spotID;
    }

    public void setSpotID(int spotID){
        this.spotID = spotID;
    }

    public List<Reservation> getReservations(){
        return reservations;
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

}
