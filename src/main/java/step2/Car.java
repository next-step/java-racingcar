package step2;

import java.util.Objects;

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
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        final Car car = (Car) o;
        return name.equals(car.name) &&
                location.equals(car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return String.format("%s-%s", name, location);
    }
}
