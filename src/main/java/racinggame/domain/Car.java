package racinggame.domain;

import java.util.Objects;

public class Car {

    private static final int DEFAULT_LOCATION = 0;
    private static final int FORWARD_NUMBER = 4;

    private final CarName name;
    private int location;

    public Car(final String name) {
        this(name, DEFAULT_LOCATION);
    }

    public Car(final String name, int location) {
        this.name = new CarName(name);
        this.location = location;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public void moveForward(final int number) {
        if (number >= FORWARD_NUMBER) {
            this.location++;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return location == car.location && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }
}
