package racinggame;

import java.util.Objects;

public class Car {

    public static final int DEFAULT_DISTANCE = 1;
    private int distance;

    public Car(int distance) {
        this.distance = distance;
    }

    public Car() {
        this.distance = DEFAULT_DISTANCE;
    }

    public void move() {
        this.distance = distance + 1;
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
        return distance == car.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

}
