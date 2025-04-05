public class Driver {
    private String name;
    private String vehicleNo;
    private DriverStatus driverStatus;
    private Location location;
    private String contact;

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", driverStatus=" + driverStatus +
                ", location=" + location +
                ", contact='" + contact + '\'' +
                '}';
    }

    public Driver(String name, String vehicleNo, Location location, String contact){
        this.name = name;
        this.vehicleNo = vehicleNo;
        this.location = location;
        this.driverStatus = DriverStatus.AVAILABLE;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
