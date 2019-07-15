import exception.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParkingBoy extends Parker {
    private List<ParkingLot> parkingLotList = new ArrayList<>();


    public ParkingBoy(ParkingLot... parkingLots) {
        parkingLotList.addAll(Arrays.asList(parkingLots));
    }

    @Override
    public Ticket park(Car car) {
        if (car == null) {
            throw new CarMissing();
        }
        boolean isCarExist = parkingLotList.stream().anyMatch(parkingLot -> parkingLot.isCarExist(car));
        if (isCarExist) {
            throw new CarExist();
        }
        ParkingLot notFullParkingLot = null;
        try{
            notFullParkingLot = parkingLotList.stream().filter(parkingLot -> !parkingLot.isFull()).findFirst().get();
        }catch (Exception e){

            throw new NotEnoughPosition();
        }

        return notFullParkingLot.park(car);
    }

    @Override
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
}
