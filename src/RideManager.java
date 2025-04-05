import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class RideManager {
    private final PassengerManager passengerManager;
    private final DriverManager driverManager;
    private static RideManager rideManager;
    private PricingStrategy pricingStrategy;
    private Queue<Ride> rides;

    private RideManager(){
        passengerManager = PassengerManager.getPassengerManagerInstance();
        driverManager = DriverManager.getDriverManagerInstance();
        pricingStrategy = new RegularPricingStrategy();
        rides = new ConcurrentLinkedDeque<>();
    }

    public static synchronized RideManager getRideManagerInstance(){
        if(rideManager == null){
            rideManager = new RideManager();
        }
        return rideManager;
    }

    public void requestRide(Passenger passenger, Location source, Location destination){
        double fare = pricingStrategy.calculateFare(source, destination);
        Ride ride = new Ride(source, destination, fare, null, passenger, RideStatus.REQUESTED);
        rides.offer(ride);
        notifyDrivers(ride);
    }

    public void notifyDrivers(Ride ride){
        for(Driver driver : driverManager.getDrivers().values()){
            if(driver.getDriverStatus() == DriverStatus.AVAILABLE){
                double distance = driver.getLocation().calculateDistance(ride.getFrom());
                if(distance <= 3.0){
                    System.out.println("Notifying Driver: " + driver.getName() + " about Ride from " + ride.getFrom() + " to " + ride.getTo() + " for " + ride.getPassenger());
                }
            }
        }
    }

    public void acceptRide(Driver driver, Ride ride) throws Exception {
        if(ride.getRideStatus() != RideStatus.REQUESTED){
            throw new Exception("Ride is already in progress/cancelled");
        }
        ride.setDriver(driver);
        ride.setRideStatus(RideStatus.ACCEPTED);
        driver.setDriverStatus(DriverStatus.BUSY);
        notifyPassenger(ride);
    }

    public void startRide(Ride ride) throws Exception{
        if(ride.getRideStatus() != RideStatus.ACCEPTED){
            throw new Exception("Ride needs to be accepted first");
        }
        ride.setRideStatus(RideStatus.IN_PROGRESS);
        notifyPassenger(ride);
    }

    public void endRide(Ride ride) throws Exception {
        if(ride.getRideStatus() != RideStatus.IN_PROGRESS){
            throw new Exception("Ride needs to be started first");
        }
        ride.setRideStatus(RideStatus.COMPLETED);
        notifyPassenger(ride);
        rides.remove(ride);
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public Queue<Ride> getRides() {
        return rides;
    }

    public void notifyPassenger(Ride ride){
        System.out.println("Hi " + ride.getPassenger().getName() + ", your current Ride Status: " + ride);
    }
}
