package racingcar.domain;

import java.util.Objects;

public class Car {

    private Position position;

    private final MoveStrategy strategy;

    public Car(Position position, MoveStrategy strategy) {
        validateMoveStrategy(strategy);
        this.position = position;
        this.strategy = strategy;
    }

    public Car(MoveStrategy strategy) {
        validateMoveStrategy(strategy);
        this.position = new Position();
        this.strategy = strategy;
    }

    public Car(int step, MoveStrategy strategy) {
        validateMoveStrategy(strategy);
        this.position = new Position(step);
        this.strategy = strategy;
    }

    private void validateMoveStrategy(MoveStrategy strategy) {
        if (Objects.isNull(strategy)) {
            throw new IllegalArgumentException("MoveStrategy must be not null");
        }
    }

    public Car move() {
        Position movedPosition = strategy.move(this.position);
        return new Car(movedPosition, strategy);
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
