package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final Name name;

    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(MoveStrategy strategy) {
        int amount = strategy.amount();
        this.position = position.move(amount);
    }

    public boolean isEqualPosition(Position position) {
        return this.position.equals(position);
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
