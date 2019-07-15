
public class Parker {

    private ParkingLot parkingLot;

    public Parker(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        parkingLot.getCarList().put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        return parkingLot.getCarList().get(ticket);
    }
}
