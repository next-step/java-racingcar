package racingcar.domain;

import java.util.Objects;

public class Car {
    public static final int MIN_CONDITION = 3;
    private Distance distance;
    private Name name;

    public Car(String name, int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public Car(String name) {
        this(name, 0);
    }

    public Car(int distance) {
        this("", distance);
    }

    public void move(int distance) {
        if (distance > MIN_CONDITION) {
            this.distance.plus();
        }
    }

    public Distance distance() {
        return this.distance;
    }

    public Name name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(distance, car.distance) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "distance=" + distance +
                ", name=" + name +
                '}';
    }
}
