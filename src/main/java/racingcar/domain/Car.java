package racingcar.domain;

import racingcar.exception.CarMovingNumberException;

import java.util.Objects;

public class Car {
    private static final int MOVE_CRITERIA = 4;
    private static final int MOVE_VALUE = 1;
    private static final int MIN_MOVEMENT_VALUE = 0;
    private static final int MAX_MOVEMENT_VALUE = 9;

    private final Name name;
    private final Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(Name name) {
        return new Car(name, Position.init());
    }

    public Car from(Car car) {
        return new Car(car.name, position.of());
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

    public Position currentPosition() {
        return position;
    }

    public String carName() {
        return name.getName();
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
