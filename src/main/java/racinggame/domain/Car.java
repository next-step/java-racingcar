package racinggame.domain;

import racinggame.domain.value.Position;

import java.util.Objects;

public class Car {

    private final String name;
    private final Position position;

    public Car(String name, Position position) {
        this.position = position;
        this.name = name;

    }

    public Car move(int moveValue) {
        position.increase(moveValue);
        return new Car(name, Position.of(position.current()));
    }

    public boolean compareSamePosition(int position) {
        return this.position
                .same(position);
    }

    public int position() {
        return position.current();
    }

    public String name() {
        return name;
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
