package org.ibgradecalc.service;

import org.ibgradecalc.model.ParkingSpot;
import org.ibgradecalc.model.Reservation;

import java.time.LocalDateTime;
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

    public Map<Integer, ParkingSpot> getSlots(){
        return slots;
    }

}
