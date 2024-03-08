package model;

import java.util.Objects;

public class Car {
    private final Position position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = new Position(position);
    }

    public void move(int random) {
        if (random >= 4) {
            this.position.move();
        }
    }

    public String hyphenatePosition() {
        return this.position.toString();
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
