package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        if (this.parkingLot.getAvailableParkingPosition() > 0) {
            ParkingTicket parkingTicket = new ParkingTicket();
            this.parkingLot.parkCar(parkingTicket, car);
            return parkingTicket;
        } else {
            this.lastErrorMessage = "Not enough position.";
            return null;
        }
    }

    public Car fetch(ParkingTicket ticket) {
        if (ticket == null) {
            this.lastErrorMessage = "Please provide your parking ticket.";
            return null;
        }
        Car car = this.parkingLot.fetchCar(ticket);
        if (car == null) {
            this.lastErrorMessage = "Unrecognized parking ticket.";
        }
        return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
