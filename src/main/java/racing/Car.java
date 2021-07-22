package racing;

public class Car {
    private Location location;

    public Location getLocation() {
        return location;
    }

    public Car() {
        this.location = new Location();
    }
}
