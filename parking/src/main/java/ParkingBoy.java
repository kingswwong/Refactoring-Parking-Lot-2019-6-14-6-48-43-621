import exception.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParkingBoy extends Parker {

    public ParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
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
}
