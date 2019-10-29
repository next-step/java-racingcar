package step2;

public class Car {
    private final String name;
    private final Location location;

    public Car(final String name) {
        this.name = name;
        this.location = Location.ZERO;
    }

    public Car(final String name, final Location location) {
        this.name = name;
        this.location = location;
    }

    public Car goForward() {
        return goForward(1, Location.Unit.STEP);
    }

    public Car goForward(final int distance) {
        return goForward(distance, Location.Unit.STEP);
    }

    public Car goForward(final int distance, final Location.Unit unit) {
        return new Car(name, location.goForward(distance, unit));
    }

    public int current() {
        return location.current();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s-%s", name, location);
    }
}
