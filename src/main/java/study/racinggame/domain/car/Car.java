package study.racinggame.domain.car;

import study.racinggame.domain.engine.MovingStrategy;

import java.util.Objects;

public class Car {
    private final Name name;
    private Position position;

    public Car(Name name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public Car(Name name) {
        this(name, 0);
    }

    public Car(String name) {
        this(new Name(name));
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position = position.increase();
        }
    }

    public String name() {
        return name.getValue();
    }

    public boolean isWinner(int max) {
        return position.maximum(max);
    }

    public int position() {
        return position.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
