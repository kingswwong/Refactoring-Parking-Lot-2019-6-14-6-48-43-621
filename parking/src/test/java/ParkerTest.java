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

    @Test
    public void should_park_multiple_car_and_fetch_the_right_car(){

        Parker parkingBoy = new Parker(new ParkingLot(1));
        Car car1 = new Car();
        Car car2 = new Car();
        parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        assertEquals(car2,parkingBoy.fetch(ticket2));
    }
}
