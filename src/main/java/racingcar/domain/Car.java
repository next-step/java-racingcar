package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private Position position;
    private final Name name;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position = position.move();
        }
    }

    public boolean isWinner(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    public boolean hasBiggerPositionThan(Position maxPosition) {
        return this.position.isBiggerThan(maxPosition);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
