package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.Objects;

public class Car {

    private final Name name;
    private Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
    }

    public Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public static Car create(String name) {
        return new Car(new Name(name));
    }

    public void move(MoveStrategy strategy) {
        if (strategy.moveCar()) {
            position = position.increase();
        }
    }

    public String getName() {
        return name.name();
    }

    public Position getPosition() {
        return position;
    }

    public Position max(Position other) {
        return this.position.max(other);
    }

    public boolean isWinner(Position other) {
        return this.position.equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName()) &&
                Objects.equals(getPosition(), car.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
