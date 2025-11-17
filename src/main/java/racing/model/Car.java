package racing.model;

import java.util.Objects;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final CarName name;
    private final Location location;

    public Car(String name) {
        this(new CarName(name), new Location());
    }

    public Car(String name, int location) {
        this(new CarName(name), new Location(location));
    }

    public Car(CarName name, Location location) {
        this.name = name;
        this.location = location;
    }

    public CarName name() {
        return name;
    }

    public void makeMove(int number) {
        if (isMovable(number)) {
            location.moveForward();
        }
    }

    public boolean isAtLocation(Location targetLocation) {
        return this.location.equals(targetLocation);
    }

    public Location max(Location maxLocation) {
        return this.location.max(maxLocation);
    }

    public String expressLocationWith(String symbol) {
        return location.toString(symbol);
    }

    private boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
