import java.util.ArrayList;

public class Passenger {

    private String name;
    private String contact;
    private Location location;
    private ArrayList<Ride> rides;

    public ArrayList<Ride> getRides() {
        return rides;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", location=" + location +
                ", rides=" + rides +
                '}';
    }

    public Passenger(String name, String contact, Location location) {
        this.name = name;
        this.contact = contact;
        this.location = location;
        this.rides = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
