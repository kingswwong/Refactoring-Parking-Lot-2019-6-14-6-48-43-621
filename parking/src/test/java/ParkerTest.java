import exception.UnRecognizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void should_throw_unrecognize_ticket_exception_when_customer_given_the_wrong_ticket(){
        Parker parkingBoy = new Parker(new ParkingLot(1));
        Car car = new Car();
        parkingBoy.park(car);
        Ticket ticket = new Ticket();
        assertThrows(UnRecognizeException.class,()->parkingBoy.fetch(ticket));
        assertThrows(UnRecognizeException.class,()->parkingBoy.fetch(null));
    }
}
