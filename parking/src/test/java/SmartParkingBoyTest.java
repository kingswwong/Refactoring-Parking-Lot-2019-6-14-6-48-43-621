import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    public void should_park_the_car_to_more_empty_parking_lot(){

        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(1,1),new ParkingLot(2,2),new ParkingLot(3,3));
        Ticket ticket = smartParkingBoy.park(car);
        assertEquals(ticket.getParkingId(),3);
    }
}
