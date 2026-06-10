package org.parkingapi.service;

import org.parkingapi.model.ParkingSpot;
import org.parkingapi.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ParkingService {

    private Map<Integer, ParkingSpot> slots= new HashMap<Integer, ParkingSpot>();

    public ParkingService(int totalSlots){
        for (int i = 1; i <= totalSlots; i++){
            slots.put(i, new ParkingSpot(i));
        }
    }

    public void setReservation(Reservation reservation, int spotID, LocalDateTime startDate, LocalDateTime endDate){

        reservation = new Reservation(spotID,startDate,endDate);

    }

    public void addReservation(int spotID, LocalDateTime startDate, LocalDateTime endDate){

        ParkingSpot currSpot = slots.get(spotID);
        List<Reservation> reservations = currSpot.getReservations();

        Boolean isOverlapping = false;

        if(currSpot.getReservations().isEmpty()){
            Reservation newReservation = new Reservation(spotID,startDate,endDate);
            currSpot.addReservation(newReservation);
        }else{
            for(int i = 0; i < currSpot.getReservations().size(); i++){
                if((reservations.get(i).isOverlapping(startDate, endDate))){
                    isOverlapping = true;
                }

            }
            if(!isOverlapping){
                Reservation newReservation = new Reservation(spotID,startDate,endDate);
                currSpot.addReservation(newReservation);
            }
        }
    }

    public Map<Integer, ParkingSpot> getSlots(){
        return slots;
    }

}
