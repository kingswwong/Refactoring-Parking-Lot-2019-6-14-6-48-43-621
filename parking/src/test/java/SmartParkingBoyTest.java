import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    public void should park the car to more empty parking lot(){

        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(1,1),new ParkingLot(2,2),new ParkingLot(3,3));
        Ticket ticket = smartParkingBoy.park(car);
        assertEquals(ticket.getParkingId(),3);
    }
}
