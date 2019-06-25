package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return capacity - cars.size();
    }

    public double getAvailableRate() {
        return ((double) getAvailableParkingPosition()) / capacity;
    }

    public void parkCar(ParkingTicket parkingTicket, Car car) {
        this.cars.put(parkingTicket, car);
    }

    public Car fetchCar(ParkingTicket parkingTicket) {
        return this.cars.remove(parkingTicket);
    }
}
