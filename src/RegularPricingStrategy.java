public class RegularPricingStrategy implements PricingStrategy{

    // 10 Rs per km
    @Override
    public double calculateFare(Location from, Location to) {
        double distance = from.calculateDistance(to);
        return distance * 10.0;
    }
}
