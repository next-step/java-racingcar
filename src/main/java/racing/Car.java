package racing;

import racing.strategy.MoveStrategy;

import java.util.Objects;

public class Car {

    private Position position;
    private final Name name;

    public Car(Name name) {
        this.position = Position.startPosition();
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean samePosition(int targetPosition) {
        return targetPosition == this.position.getPosition();
    }

    public void play(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position = position.add(1);
        }
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
