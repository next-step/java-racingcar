package racingcar;

import java.util.Objects;

public class Car {
    private int location;
    public static final int MOVE_DISTANCE = 1;
    public static final int START_LOCATION = 1;

    private Car(int location) {
        this.location = location;
    }

    private Car() {
        this.location = START_LOCATION;
    }

    public static Car from(int location) {
        return new Car(location);
    }

    public static Car from() {
        return new Car();
    }

    public void moveForward() {
        location += MOVE_DISTANCE;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return location == car.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
