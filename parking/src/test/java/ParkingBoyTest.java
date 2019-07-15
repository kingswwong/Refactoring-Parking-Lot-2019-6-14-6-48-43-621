import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyTest {

    @Test
    public void should_park_the_car_to_next_parking_lots_when_the_other_is_full(){
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1),new ParkingLot(1));
        parkingBoy.park(new Car());
        Ticket ticket = parkingBoy.park(car);
        assertEquals(car,parkingBoy.fetch(ticket));
    }
}
