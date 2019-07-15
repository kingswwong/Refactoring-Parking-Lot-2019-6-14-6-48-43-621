import exception.CarExist;
import exception.CarMissing;
import exception.NotEnoughPosition;
import exception.UnRecognizeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {

    private List<Parkable> parkables = new ArrayList<>();


    public Manager(Parker... parkers) {
        parkables.addAll(Arrays.asList(parkers));
    }


    public Ticket park(Car car) {
        for(Parkable parkable:parkables){
            if(!parkable.isFull()){
                return parkable.park(car);
            }
        }
        throw new NotEnoughPosition();
    }

    public Car fetch(Ticket ticket){
        for(Parkable parkable:parkables){
            if(parkable.containsTicket(ticket)){
                return parkable.fetch(ticket);
            }
        }
        throw new UnRecognizeException();
    }

    public void addParkingLots(ParkingLot... parkingLots){
        this.parkables.addAll(Arrays.asList(parkingLots));
    }
}
