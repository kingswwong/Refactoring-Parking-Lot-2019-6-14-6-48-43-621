import exception.*;

public class Parker {

    private ParkingLot parkingLot;

    public Parker(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) {
        if(car == null){
            throw new CarMissing();
        }
        if(parkingLot.isCarExist(car)){
            throw new CarExist();
        }
        if(parkingLot.isFull()){
            throw new NotEnoughPosition();
        }
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
