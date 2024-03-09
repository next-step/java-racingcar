package model;

import java.util.Objects;

public class Car {
    private final Position position;
    private final MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        this(0, moveStrategy);
    }

    public Car(int position, MoveStrategy strategy) {
        this.position = new Position(position);
        this.moveStrategy = strategy;
    }

    public void move() {
        if (moveStrategy.movable()) {
            this.position.move();
        }
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(moveStrategy, car.moveStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, moveStrategy);
    }
}
