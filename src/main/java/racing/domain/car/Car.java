package racing.domain.car;

import racing.domain.Location;
import racing.domain.Name;
import racing.domain.fuel.Fuel;
import util.RepeatString;

import java.util.Objects;

public final class Car {
    private final Name name;
    private final Location location;

    public Car(Name name) {
        this.name = name;
        this.location = Location.empty();
    }

    public Car(Name name, Location location) {
        this.name = name;
        this.location = location;
    }

    public Car move(Fuel fuel) {
        if (fuel.isMovable()) {
            Location newLocation = this.location.add(Location.oneBlock());
            return new Car(name, newLocation);
        }
        return this;
    }

    public int compareLocation(Car compareValue) {
        return this.location.compareTo(compareValue.location);
    }

    public RepeatString locationToRepeatString(String repeatUnit) {
        return new RepeatString(this.location, repeatUnit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car basicCar = (Car) o;
        return name.equals(basicCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
