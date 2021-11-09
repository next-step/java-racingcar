package racingcar.domain;

import racingcar.exception.CarMovingNumberException;

import java.util.Objects;

public class Car {
    private static final int MOVE_CRITERIA = 4;
    private static final int MOVE_VALUE = 1;
    private static final int MIN_MOVEMENT_VALUE = 0;
    private static final int MAX_MOVEMENT_VALUE = 9;

    private Position position;

    private Car(Position position) {
        this.position = position;
    }

    public static Car from() {
        return new Car(Position.init());
    }

    public void move(int number) {
        validateMoveNum(number);
        if (number > MOVE_CRITERIA) {
            position.move(MOVE_VALUE);
        }
    }

    private void validateMoveNum(int number) {
        if (number < MIN_MOVEMENT_VALUE || number > MAX_MOVEMENT_VALUE) {
            throw new CarMovingNumberException(number);
        }
    }

    public int currentPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
