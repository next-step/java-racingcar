package racingcar.domain;

import racingcar.condition.MoveCondition;

import java.util.Objects;

public class Car {

    private final MoveCondition moveCondition;
    private final Name name;
    private final Position position;

    public Car(final String name, final MoveCondition moveCondition) {
        this(name, 0, moveCondition);
    }

    public Car(final String name, final int position, final MoveCondition moveCondition) {
        this.name = new Name(name);
        this.position = new Position(position);
        this.moveCondition = moveCondition;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public boolean hasMaxPosition(int position) {
        return this.position.hasMaxPosition(position);
    }

    public int comparePosition(int position) {
        return this.position.comparePosition(position);
    }

    public void move(MoveCondition moveCondition) {
        if (moveCondition.isMovable()) {
            this.position.move();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(moveCondition, car.moveCondition) && Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveCondition, name, position);
    }
}
