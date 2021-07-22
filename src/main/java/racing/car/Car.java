package racing.car;

public class Car {
    private Location location;

    public Car() {
        this.location = Location.EMPTY;
    }

    public Location getLocation() {
        return location;
    }

    public void move(Fuel fuel) {
        if (fuel.isMovable())
            this.location = location.add(Location.ONE_BLOCK);
    }
}
