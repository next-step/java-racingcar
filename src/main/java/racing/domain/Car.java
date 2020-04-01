package racing.domain;

import java.util.Objects;

public class Car {
    private static final int DEFAULT_POSITION = 1;
    private String name;
    private int position;

    public Car() {
        position = DEFAULT_POSITION;
    }

    public Car(String name) {
        this.name  = name;
        this.position = DEFAULT_POSITION;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int moveByCondition(int condition) {
        if (Movable.isMovable(condition)) {
            return moveForward();
        }

        return position;
    }

    private int moveForward() {
        return ++position;
    }

    public Car copy() {
        return new Car(name, position);
    }

    public int getPosition() {
        return position;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}