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
            return null;
        }
    }

    public Car fetch(ParkingTicket ticket) {
        return this.parkingLot.fetchCar(ticket);
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
