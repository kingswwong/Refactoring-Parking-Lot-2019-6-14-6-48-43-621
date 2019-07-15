import exception.CarExist;
import exception.CarMissing;
import exception.NotEnoughPosition;

public class SmartParkingBoy extends Parker{

    public SmartParkingBoy(ParkingLot... parkingLots) {
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
        ParkingLot moreEmptyParkingLot = null;
        try{
            moreEmptyParkingLot = parkingLotList.stream().filter(parkingLot -> !parkingLot.isFull()).sorted((parkingLot1,parkingLot2) -> parkingLot2.getRemainingPosition() - parkingLot1.getRemainingPosition()).findFirst().get();
        }catch (Exception e){
            throw new NotEnoughPosition();
        }

        return moreEmptyParkingLot.park(car);
    }

}
