import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {

    @Test
    void should_park_the_car_to_have_more_parking_rate_parking_lot() {
        Car car = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot(20,2),new ParkingLot(10,1));
        superSmartParkingBoy.park(new Car());
        Ticket ticket = superSmartParkingBoy.park(car);
        assertEquals(ticket.getParkingId(),1);
    }
}
