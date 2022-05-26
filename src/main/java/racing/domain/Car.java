package racing.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final CarName name;
    private Location location;

    public Car(final String name) {
        this(name, Location.defaultLocation());
    }

    public Car(final String name, final Location location) {
        this.name = new CarName(name);
        this.location = location;
    }

    public void run(GameRule gameRule) {
        if (gameRule.isPassedCondition()) {
            this.location = location.forward();
        }
    }

    public boolean isEqualLocation(Car car) {
        return this.location.equals(car.location);
    }

    public CarName getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        final Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return "Car{" +
               "name=" + name +
               ", location=" + location +
               '}';
    }

    @Override
    public int compareTo(final Car o) {
        return this.location.compareTo(o.location);
    }
}
