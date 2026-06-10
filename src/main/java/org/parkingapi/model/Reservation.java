package org.parkingapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int spotID;

    public Reservation(int spotID, LocalDateTime startDate, LocalDateTime endDate){
        this.spotID = spotID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public int getSpotID() {
        return spotID;
    }

    public Boolean isOverlapping(LocalDateTime newStart, LocalDateTime newEnd){
        return this.startDate.isBefore(newEnd) && this.endDate.isAfter(newStart);
    }
}
