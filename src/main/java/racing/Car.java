package racing;

public class Car {

    private Location location;

    public Car(Location location) {
        this.location = location;
    }

    public Location getCarLocationInfo() {
        return this.location;
    }

    public int getLocation() {
        return this.location.getLocation();
    }

}
