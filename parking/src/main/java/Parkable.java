public interface Parkable {
    Ticket park(Car car);
    Car fetch(Ticket ticket);
    boolean isFull();
    boolean containsTicket(Ticket ticket);
}
