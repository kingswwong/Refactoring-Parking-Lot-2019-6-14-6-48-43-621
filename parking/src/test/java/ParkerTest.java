import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

import static org.junit.Assert.*;

public class ParkerTest {
    @Test
    public void should_parking_boy_park_a_car_and_fetch_a_car(){

        ParkingLot parkingLot = new ParkingLot(1);
        Parker parkingBoy = new Parker(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        assertEquals(car,parkingBoy.fetch(ticket));
    }
}
