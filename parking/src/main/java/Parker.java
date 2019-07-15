import exception.TicketMissing;
import exception.UnRecognizeException;

public class Parker {

    private ParkingLot parkingLot;

    public Parker(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        if(ticket == null){
            throw new TicketMissing();
        }
        boolean isContainsTicket = parkingLot.containsTicket(ticket);
        if(!isContainsTicket){
            throw new UnRecognizeException();
        }
        return parkingLot.fetch(ticket);
    }
}
