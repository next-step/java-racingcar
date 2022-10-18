package racingcar.domain;

import java.util.Objects;

import static racingcar.domain.RandomNumber.isNotLessThanThreshold;

public class Car {
    private static final int MOVABLE_THRESHOLD = 4;

    private static final int CAR_NAME_THRESHOLD = 5;

    private static final String CAR_NAME_LENGTH_EXCEPTION = "자동차 이름은 5자를 초과할 수 없습니다.";

    private final String name;

    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car nameOf(String name) throws IllegalArgumentException {
        validateCarNames(name);
        return new Car(name);
    }

    private static void validateCarNames(String name) throws IllegalArgumentException {
        if (isOverThreshold(name)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION);
        }
    }

    private static boolean isOverThreshold(String name) {
        return name.length() > CAR_NAME_THRESHOLD;
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

    public void moveForward() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return isNotLessThanThreshold(Car.MOVABLE_THRESHOLD);
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
