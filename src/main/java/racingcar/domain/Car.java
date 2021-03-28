package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.Objects;

import static racingcar.exception.Message.MAX_LENGTH_ERROR;
import static racingcar.exception.Message.NULL_OR_EMPTY_ERROR;

public class Car {

    private static final int LIMIT = 5;

    private int position;
    private String name;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    private void validate(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR);
        }
        if (name.length() > LIMIT) {
            throw new IllegalArgumentException(MAX_LENGTH_ERROR);
        }
    }

    public Car move(MoveStrategy strategy) {
        if (strategy.moveCar()) {
            return new Car(name, position + 1);
        }
        return new Car(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getPosition() == car.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
