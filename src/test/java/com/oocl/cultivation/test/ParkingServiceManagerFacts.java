package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingServiceManagerFacts {

    @Test
    void should_can_add_parking_boy_to_list() {
        List<ParkingBoy> parkingBoys = new ArrayList<>();
        ParkingServiceManager parkingServiceManager = new ParkingServiceManager(new ArrayList<>(), parkingBoys);

        ParkingBoy parkingBoy = new ParkingBoy(new ArrayList<>());
        parkingServiceManager.addParkingBoy(parkingBoy);

        assertEquals(1, parkingBoys.size());
        assertEquals(parkingBoy, parkingBoys.get(0));
    }

    @Test
    void should_can_drive_other_parking_boy_to_park_car() {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        ParkingServiceManager parkingServiceManager = new ParkingServiceManager(new ArrayList<>(), Collections.singletonList(parkingBoy));
        Car car = new Car();

        ParkingTicket parkingTicket = parkingServiceManager.parkBy(parkingBoy, car);

        assertEquals(car, parkingBoy.fetch(parkingTicket));
    }

    @Test
    void should_can_drive_other_parking_boy_to_fetch_car() {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);
        ParkingServiceManager parkingServiceManager = new ParkingServiceManager(new ArrayList<>(), Collections.singletonList(parkingBoy));

        assertEquals(car, parkingServiceManager.fetchBy(parkingBoy, parkingTicket));
    }

    @Test
    void should_set_error_message_same_as_other_parking_boy_when_get_error_for_fetching() {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        Car car = new Car();
        parkingBoy.park(car);
        ParkingServiceManager parkingServiceManager = new ParkingServiceManager(new ArrayList<>(), Collections.singletonList(parkingBoy));

        parkingServiceManager.fetchBy(parkingBoy, null);

        assertEquals(
                "Please provide your parking ticket.",
                parkingServiceManager.getLastErrorMessage()
        );
    }

    @Test
    void should_set_error_message_same_as_other_parking_boy_when_get_error_for_parking() {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        Car car = new Car();
        parkingBoy.park(car);
        ParkingServiceManager parkingServiceManager = new ParkingServiceManager(new ArrayList<>(), Collections.singletonList(parkingBoy));

        parkingServiceManager.parkBy(parkingBoy, new Car());

        assertEquals("Not enough position.", parkingServiceManager.getLastErrorMessage());
    }
}
