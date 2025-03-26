package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int POSITION_MIN_VALUE = 0;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateNotNullAndLength(name);
        validatePositive(position);
        this.name = name;
        this.position = position;
    }

    private void validateNotNullAndLength(String name) {
        if (name == null || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("length of name should be less than %d", NAME_MAX_LENGTH));
        }
    }

    private void validatePositive(int position) {
        if (position < POSITION_MIN_VALUE) {
            throw new IllegalArgumentException("position은 0 이상이어야 합니다. position:" + position);
        }
    }

    public CarState toState() {
        return new CarState(name, position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) position++;
    }

    public boolean isSamePositionWith(Car other) {
        return position == other.position;
    }

    public Car findCarAhead(Car other) {
        return position > other.position ? this : other;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}