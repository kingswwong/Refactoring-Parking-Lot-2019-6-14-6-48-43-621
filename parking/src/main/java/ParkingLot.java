import java.util.HashMap;

public class ParkingLot {
    private final int capcity;
    private HashMap<Ticket,Car> carList = new HashMap<>();
    private int id;

    public ParkingLot(int capcity) {
        this.capcity = capcity;
    }

    public ParkingLot(int capcity,  int id) {
        this.capcity = capcity;
        this.id = id;
    }

    public HashMap<Ticket, Car> getCarList() {
        return carList;
    }

    public void setCarList(HashMap<Ticket, Car> carList) {
        this.carList = carList;
    }

    public Ticket park(Car car){
        Ticket ticket = new Ticket(id);
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

    public boolean isCarExist(Car car){
        return carList.values().contains(car);
    }

    public int getRemainingPosition(){
        return capcity - carList.size();
    }
}
