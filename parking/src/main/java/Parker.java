import exception.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Parker {
    protected List<ParkingLot> parkingLotList = new ArrayList<>();

    public Parker(ParkingLot... parkingLots) {
        parkingLotList.addAll(Arrays.asList(parkingLots));
    }

    public abstract Ticket park(Car car);

    public Car fetch(Ticket ticket) {
        if(ticket == null){
            throw new TicketMissing();
        }
        ParkingLot correspondingParkingLot = null;
        try{
            correspondingParkingLot = parkingLotList.stream().filter(parkingLot -> parkingLot.containsTicket(ticket)).findFirst().get();
        }catch (Exception e){
            throw new UnRecognizeException();
        }

        return correspondingParkingLot.fetch(ticket);
    }

    public boolean isFull(){
        return parkingLotList.stream().anyMatch(parkingLot -> parkingLot.isFull());
    }

    public boolean containsTicket(Ticket ticket){
        return parkingLotList.stream().anyMatch(parkingLot -> parkingLot.containsTicket(ticket));
    }
}
