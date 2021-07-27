package racingcar.domain;

import java.util.Objects;

public class Car {

    private Name name;
    private Distance distance;

    public Car(String name) {
        this.name = Name.from(name);
        this.distance = Distance.from(0);
    }

    public Car(String name, int distance) {
        this.name = Name.from(name);
        this.distance = Distance.from(distance);
    }

    public Car move(boolean isMove) {
        if (isMove) {
            distance = distance.move();
            return new Car(name.getValue(), distance.getValue());
        }
        return new Car(name.getValue(), distance.getValue());
    }

    public boolean isEqualsDistance(Distance distance) {
        return this.distance.equals(distance);
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
