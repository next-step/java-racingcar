package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final Position position;
    private final Name name;

    public Car(Car car) {
        this.position = car.position;
        this.name = new Name(car.name);
    }

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public void move(MoveType moveType) {
        position.move(moveType);
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
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

        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    @Override
    public int compareTo(Car o) {
        if (o == null || getClass() != o.getClass()) {
            throw new IllegalArgumentException();
        }
        if (this == o) {
            return 0;
        }

        return this.position.compareTo(o.position);
    }
}
