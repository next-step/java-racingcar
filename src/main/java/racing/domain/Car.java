package racing.domain;

import racing.domain.strategy.MoveStrategy;

import java.util.Objects;

public class Car {

    private Position position;
    private final Name name;

    private Car(String name) {
        this.position = Position.startPosition();
        this.name = Name.from(name);
    }

    public static Car from(final String name) {
        return new Car(name);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public int maxPosition(int targetNumber) {
        return position.max(targetNumber);
    }

    public boolean samePosition(int targetPosition) {
        return position.equals(Position.valueOf(targetPosition));
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
