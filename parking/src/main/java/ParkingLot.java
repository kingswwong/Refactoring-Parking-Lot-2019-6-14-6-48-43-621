import java.util.HashMap;

public class ParkingLot {
    private final int capcity;
    private HashMap<Ticket,Car> carList = new HashMap<>();


    public ParkingLot(int capcity) {
        this.capcity = capcity;
    }

    public HashMap<Ticket, Car> getCarList() {
        return carList;
    }

    public void setCarList(HashMap<Ticket, Car> carList) {
        this.carList = carList;
    }
}
