package racingcar;

import java.util.Objects;

public class Car {
    public static final int VALUE = 3;
    private int distance;

    public Car() {}

    public Car(int distance) {
        this.distance = distance;
    }

    protected void move(int randomNumber) {
        if (randomNumber > VALUE) {
            distance++;
        }
    }

    int distance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    @Override
    public String toString() {
        return "Car{" +
                "distance=" + distance +
                '}';
    }
}
