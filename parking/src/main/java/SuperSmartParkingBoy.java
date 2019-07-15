import exception.CarExist;
import exception.CarMissing;
import exception.NotEnoughPosition;

public class SuperSmartParkingBoy extends Parker{

    public SuperSmartParkingBoy(ParkingLot... parkingLots) {
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
        ParkingLot moreParkingRate = null;
        try{
            moreParkingRate = parkingLotList.stream().filter(parkingLot -> !parkingLot.isFull()).sorted((parkingLot1,parkingLot2) -> {
                return parkingLot1.getParkingRate() > parkingLot2.getParkingRate() ? 1 : -1;
            }).findFirst().get();
        }catch (Exception e){

            throw new NotEnoughPosition();
        }

        return moreParkingRate.park(car);
    }
}
