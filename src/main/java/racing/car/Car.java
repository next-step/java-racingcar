package racing.car;

public class Car {
    public static final int REQUIRED_FUEL_VALUE = 4;
    private Location location;

    public Car() {
        this.location = Location.EMPTY;
    }

    public Location getLocation() {
        return location;
    }

    public void move(Fuel fuel) {
        if (fuel.isMovable(REQUIRED_FUEL_VALUE))
            this.location = location.add(Location.ONE_BLOCK);
    }
}
