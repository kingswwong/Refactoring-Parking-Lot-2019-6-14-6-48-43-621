import exception.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkerTest {
    @Test
    public void should_parking_boy_park_a_car_and_fetch_a_car(){
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        Ticket ticket = parkingBoy.park(car);

        assertEquals(car,parkingBoy.fetch(ticket));
    }

    @Test
    public void should_park_multiple_car_and_fetch_the_right_car(){
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(2));
        Car car1 = new Car();
        Car car2 = new Car();
        parkingBoy.park(car1);

        Ticket ticket2 = parkingBoy.park(car2);

        assertEquals(car2,parkingBoy.fetch(ticket2));
    }

    @Test
    public void should_throw_unrecognize_ticket_exception_when_customer_given_the_wrong_ticket(){
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        Car car = new Car();
        parkingBoy.park(car);
        Ticket ticket = new Ticket();
        assertThrows(UnRecognizeException.class,()->parkingBoy.fetch(ticket));
        assertThrows(TicketMissing.class,()->parkingBoy.fetch(null));
    }

    @Test
    public void should_unrecognize_ticket__exception_when_customer_given_the_used_ticket(){
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);

        assertThrows(UnRecognizeException.class,()-> parkingBoy.fetch(ticket));
    }

    @Test
    public void should_throw_parking_lot_is_full_when_parking_lot_is_full(){
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        Car car1 = new Car();
        Car car2 = new Car();

        parkingBoy.park(car1);

        assertThrows(NotEnoughPosition.class,()-> parkingBoy.park(car2));
    }

    @Test
    public void should_throw_car_missing_exception_when_customer_given_a_null_car(){
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));

        assertThrows(CarMissing.class,()-> parkingBoy.park(null));
    }

    @Test
    public void should_throw_car_exist_exception_when_customer_given_a_parked_car(){
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(2));
        Car car = new Car();
        parkingBoy.park(car);
        assertThrows(CarExist.class,()-> parkingBoy.park(car));
    }
}
