package racing.domain;

import java.util.Objects;

import racing.exception.GameException;

public class Car {
    private static final int CAR_NAME_LENGTH = 5;
    private final String name;
    private Location location;

    public Car(final String name) {
        this(name, Location.defaultLocation());
    }

    public Car(final String name, final Location location) {
        validate(name);
        this.name = name;
        this.location = location;
    }

    private void validate(final String name) {
        if (name.length() > CAR_NAME_LENGTH) {
            throw new GameException("car name length can't exceed " + CAR_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void run(GameRule gameRule) {
        if (gameRule.isPassedCondition()) {
            this.location = location.forward();
        }
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
               "name='" + name + '\'' +
               ", location=" + location +
               '}';
    }
}
