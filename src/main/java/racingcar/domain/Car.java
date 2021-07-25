package racingcar.domain;

import java.util.Objects;

public class Car {

    private Name name;
    private Distance distance;

    public Car(final String name) {
        this.name = Name.from(name);
        this.distance = Distance.from();
    }

    public void move(boolean isMove) {
        if (isMove) {
            distance.move();
        }
    }

    public Distance getDistance() {
        return this.distance;
    }

    public Name getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
