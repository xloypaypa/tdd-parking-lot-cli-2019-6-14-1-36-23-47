package com.oocl.cultivation;

import java.util.Collections;
import java.util.Comparator;
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
        this.parkingLot.sort((o1, o2) -> -Double.compare(o1.getAvailableRate(), o2.getAvailableRate()));
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
        for (ParkingLot parkingLot : this.parkingLot) {
            Car car = parkingLot.fetchCar(ticket);
            if (car != null) {
                this.lastErrorMessage = null;
                return car;
            }
        }
        this.lastErrorMessage = "Unrecognized parking ticket.";
        return null;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
