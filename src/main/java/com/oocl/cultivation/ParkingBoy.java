package com.oocl.cultivation;

import java.util.Collections;
import java.util.List;

public class ParkingBoy {

    private final List<ParkingLot> parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = Collections.singletonList(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        for (ParkingLot parkingLot : this.parkingLot) {
            if (parkingLot.getAvailableParkingPosition() <= 0) continue;
            ParkingTicket parkingTicket = new ParkingTicket();
            parkingLot.parkCar(parkingTicket, car);
            this.lastErrorMessage = null;
            return parkingTicket;
        }
        this.lastErrorMessage = "Not enough position.";
        return null;
    }

    public Car fetch(ParkingTicket ticket) {
        if (ticket == null) {
            this.lastErrorMessage = "Please provide your parking ticket.";
            return null;
        }
        Car car = this.parkingLot.get(0).fetchCar(ticket);
        if (car == null) {
            this.lastErrorMessage = "Unrecognized parking ticket.";
            return null;
        } else {
            this.lastErrorMessage = null;
            return car;
        }
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
