package racingcar;

import java.util.Objects;

public class Car {
    public static final int STOP_LOWER_BOUNDARY = 0;
    public static final int RUN_LOWER_BOUNDARY = 4;
    public static final int RUN_UPPER_BOUNDARY = 10;

    public static final int START_POINT = 0;

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = START_POINT;
    }

    public void initialize() {
        this.distance = START_POINT;
    }

    public CarState runOrStop(int number) {
        if (number < STOP_LOWER_BOUNDARY || number > RUN_UPPER_BOUNDARY) {
            throw new IllegalArgumentException("Random Number should be between 0 to 10.");
        }

        if (number >= RUN_LOWER_BOUNDARY) {
            distance++;
        }

        return new CarState(name, distance);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Car car = (Car) obj;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Car(" + this.name + ") → ";
    }
}
