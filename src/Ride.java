public class Ride {
    private final Location from;
    private final Location to;
    private double price;
    private Driver driver;
    private final Passenger passenger;
    private RideStatus rideStatus;

    @Override
    public String toString() {
        return "Ride{" +
                "from=" + from +
                ", to=" + to +
                ", price=" + price +
                ", driver=" + driver +
                ", passenger=" + passenger +
                ", rideStatus=" + rideStatus +
                '}';
    }

    public Ride(Location from, Location to, double price, Driver driver, Passenger passenger, RideStatus rideStatus) {
        this.from = from;
        this.to = to;
        this.price = price;
        this.driver = driver;
        this.passenger = passenger;
        this.rideStatus = rideStatus;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}
