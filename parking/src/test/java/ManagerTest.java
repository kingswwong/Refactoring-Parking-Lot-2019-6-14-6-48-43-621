import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerTest {
    @Test
    void should_add_parking_boy_to_parking_boy_list_in_manager() {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(2));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot(1));
        Manager manager = new Manager(parkingBoy,smartParkingBoy,smartParkingBoy,superSmartParkingBoy);
        Car car = new Car();
        Ticket ticket = manager.park(car);
        assertEquals(car,manager.fetch(ticket));
    }
}
