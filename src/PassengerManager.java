import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PassengerManager {
    private Map<String, Passenger> passengers;
    private static PassengerManager passengerManager;

    private PassengerManager(){
        passengers = new ConcurrentHashMap<>();
    }

    public static synchronized PassengerManager getPassengerManagerInstance(){
        if(passengerManager == null){
            passengerManager = new PassengerManager();
        }
        return passengerManager;
    }

    public void addPassenger(Passenger passenger){
        passengers.put(passenger.getName(), passenger);
    }

    public void removePassenger(Passenger passenger) throws Exception {
        if(!passengers.containsKey(passenger.getName())){
            throw new Exception("Passenger not found");
        }
        passengers.remove(passenger.getName());
    }
}
