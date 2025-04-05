import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DriverManager {
    private Map<String, Driver> drivers;
    private static DriverManager driverManager;

    public Map<String, Driver> getDrivers() {
        return drivers;
    }

    private DriverManager(){
        drivers = new ConcurrentHashMap<>();
    }

    public static synchronized DriverManager getDriverManagerInstance(){
        if(driverManager == null){
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    public void addDriver(Driver driver){
        drivers.put(driver.getName(), driver);
    }

    public void removeDriver(Driver driver) throws Exception {
        if(!drivers.containsKey(driver.getName())){
            throw new Exception("Driver not found");
        }
        drivers.remove(driver.getName());
    }
}
