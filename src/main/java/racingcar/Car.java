package racingcar;

import java.util.Objects;

public class Car {

    public static final int MOVE_DISTANCE = 1;

    private int location;

    private Car(int location) {
        this.location = location;
    }

    public static Car from(int location) {
        return new Car(location);
    }

    public static Car from(Car car) {
        return new Car(car.location);
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
