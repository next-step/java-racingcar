package racingcar.domain;

import java.util.*;

public class Car {
    private static final int START = 0;

    private Position position;
    private Name name;

    public Car(String name) {
        this(name, START);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Position drive() {
        position = position.move();
        return position;
    }

    public int getDistance() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public int compare(int otherPosition) {
        return position.comparePosition(otherPosition);
    }

    public boolean isSamePosition(int maxPosition) {
        return position.equalPosition(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
