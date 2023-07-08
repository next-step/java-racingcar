package racingcar.domain;

import java.util.Objects;

import static java.lang.String.format;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_STANDARD = 4;
    private static final String MAX_NAME_OVER_MESSAGE = format("자동차 이름은 %s글자 이하여야 합니다", MAX_NAME_LENGTH);
    private final String name;
    private int distance;

    public Car(final String name) {
        validateName(name);
        this.name = name;
    }

    public Car(final String name, final int distance) {
        this(name);
        this.distance = distance;
    }

    public Car(final Car car) {
        this.name = car.name;
        this.distance = car.distance;
    }

    private void validateName(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_NAME_OVER_MESSAGE);
        }
    }

    public boolean isSameDistance(final int maxDistance) {
        return distance == maxDistance;
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

    public void progress(final int number) {
        if (number >= MOVE_STANDARD) {
            forward();
        }
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
}
