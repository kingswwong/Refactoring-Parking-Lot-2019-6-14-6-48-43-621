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

    public Ticket park(Car car){
        Ticket ticket = new Ticket();
        this.carList.put(ticket,car);
        return ticket;
    }

    public Car fetch(Ticket ticket){
        Car car = carList.get(ticket);
        carList.remove(ticket);
        return car;
    }

    public boolean containsTicket(Ticket ticket) {
        return carList.containsKey(ticket);
    }

    public boolean isFull() {
        return capcity <= carList.size();
    }
}
