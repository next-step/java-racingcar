package racinggame.domain;

import racinggame.domain.value.Name;
import racinggame.domain.value.Position;

import java.util.Objects;

public class Car {
    private static final int ADVANCED_CONDITION = 4;

    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.position = position;
        this.name = name;
    }

    public Car move(int moveValue) {
        if(validateMoveValue(moveValue)) {
            position.increase();
        }

        return new Car(name, Position.of(position.current()));
    }

    public boolean isSamePosition(int position) {
        return this.position
                .isSame(position);
    }

    public int position() {
        return position.current();
    }

    public String name() {
        return name.value();
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

    private boolean validateMoveValue(int moveValue) {
        return moveValue >= ADVANCED_CONDITION;
    }
}
