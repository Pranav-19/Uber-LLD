
public class Main {
    public static void main(String[] args) throws Exception {
        Driver d1 = new Driver("Mohammed", "1234", new Location(2,5), "1234567890");
        Driver d2 = new Driver("Irfan", "5678", new Location(1,6), "3434782233");
        Driver d3 = new Driver("Yusuf", "8718", new Location(6,10), "3277328792");

        DriverManager driverManager = DriverManager.getDriverManagerInstance();
        driverManager.addDriver(d1);
        driverManager.addDriver(d2);
        driverManager.addDriver(d3);

        Passenger p1 = new Passenger("Pranav", "2871819328", new Location(3, 4));
        Passenger p2 = new Passenger("Pratik", "2732832327", new Location(0, 3));
        Passenger p3 = new Passenger("Sagar", "32737388823", new Location(9, 6));

        PassengerManager passengerManager = PassengerManager.getPassengerManagerInstance();
        passengerManager.addPassenger(p1);
        passengerManager.addPassenger(p2);
        passengerManager.addPassenger(p3);

        RideManager rideManager = RideManager.getRideManagerInstance();
        rideManager.requestRide(p1, p1.getLocation(), new Location(10, 20));
        rideManager.requestRide(p3, p3.getLocation(), new Location(0, 0));

        Ride ride = rideManager.getRides().poll();
        rideManager.acceptRide(d1, ride);

        Ride ride2 = rideManager.getRides().poll();
        rideManager.acceptRide(d3, ride2);

        Thread.sleep(3000);
        rideManager.startRide(ride);
        Thread.sleep(3000);
        rideManager.startRide(ride2);

        Thread.sleep(5000);
        rideManager.endRide(ride2);
        rideManager.endRide(ride);
    }
}