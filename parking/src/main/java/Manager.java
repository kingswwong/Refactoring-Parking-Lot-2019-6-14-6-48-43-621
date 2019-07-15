import exception.CarExist;
import exception.CarMissing;
import exception.NotEnoughPosition;
import exception.UnRecognizeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {
    private List<Parker> parkerList = new ArrayList<>();

    public Manager(Parker... parkers) {
        parkerList.addAll(Arrays.asList(parkers));
    }

    public Ticket park(Car car) {
        for(Parker parker:parkerList){
            if(!parker.isFull()){
                return parker.park(car);
            }
        }
        throw new NotEnoughPosition();
    }

    public Car fetch(Ticket ticket){
        for(Parker parker:parkerList){
            if(parker.containsTicket(ticket)){
                return parker.fetch(ticket);
            }
        }
        throw new UnRecognizeException();
    }
}
