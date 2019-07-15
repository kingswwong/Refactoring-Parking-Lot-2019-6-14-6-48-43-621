import exception.*;

public abstract class Parker {


    public abstract Ticket park(Car car);

    public abstract Car fetch(Ticket ticket);

}
