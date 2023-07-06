package racingcar;

import java.util.Objects;

public class Car {

    private static final int MAX_NAME_SIZE = 5;
    private static final int FORWARD_THRESHHOLD = 4;

    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    void forward() {
        distance++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }

    public void progress() {
        int number = RandomGenerator.generateNumber();
        if (number >= FORWARD_THRESHHOLD) {
            forward();
        }
    }
}
