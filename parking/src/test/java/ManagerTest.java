import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerTest {
    @Test
    void should add parking boy to parking boy list in manager() {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(2));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot(1));
        Manager manager = new Manager(parkingBoy,smartParkingBoy,smartParkingBoy,superSmartParkingBoy);
        Car car = new Car();
        Ticket ticket = manager.park(car);
        assertEquals(car,manager.fetch(ticket));
    }

    @Test
    void should add park by manager himself () {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(0));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(0));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(new ParkingLot(0));
        Manager manager = new Manager(parkingBoy,smartParkingBoy,smartParkingBoy,superSmartParkingBoy);
        manager.addParkingLots(new ParkingLot(2));
        Car car = new Car();
        Ticket ticket = manager.park(car);
        assertEquals(car,manager.fetch(ticket));
    }
}
