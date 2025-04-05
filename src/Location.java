public class Location {
    private final int x;
    private final int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double calculateDistance(Location location){
        return Math.sqrt(Math.pow(x - location.x, 2) + Math.pow(y - location.y, 2));
    }
}
