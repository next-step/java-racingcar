package racingcar.domain;

import java.util.Objects;

import static racingcar.domain.RandomNumber.isNotLessThanThreshold;

public class Car {
    private int position = 0;

    private final String name;

    private Car(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getPosition() == car.getPosition() && getName().equals(car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition(), getName());
    }

    public static Car nameOf(String name) {
        return new Car(name);
    }

    public void moveForward(int movableThreshold) {
        if (isMovable(movableThreshold)) {
            position++;
        }
    }

    private boolean isMovable(int movableThreshold) {
        return isNotLessThanThreshold(movableThreshold);
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }
}
