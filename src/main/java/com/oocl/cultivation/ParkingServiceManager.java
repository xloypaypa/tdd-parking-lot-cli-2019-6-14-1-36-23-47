package com.oocl.cultivation;

import java.util.List;

public class ParkingServiceManager extends ParkingBoy {

    private final List<ParkingBoy> parkingBoys;

    public ParkingServiceManager(ParkingLot parkingLot, List<ParkingBoy> parkingBoys) {
        super(parkingLot);
        this.parkingBoys = parkingBoys;
    }

    public ParkingServiceManager(List<ParkingLot> parkingLot, List<ParkingBoy> parkingBoys) {
        super(parkingLot);
        this.parkingBoys = parkingBoys;
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        this.parkingBoys.add(parkingBoy);
    }
}
