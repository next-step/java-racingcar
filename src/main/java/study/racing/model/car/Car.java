package study.racing.model.car;

import java.util.Objects;

import study.racing.model.Name;
import study.racing.model.rule.Rule;

public class Car {

    private final Name name;
    private int distance;

    public Car(Name name) {
        this.name = name;
    }

    public void moveOrStop(Rule rule) {
        if (rule.isFollowRule()) {
            move();
        }
    }

    private void move() {
        this.distance++;
    }

    public int getDistance() {
        return distance;
    }

    public Name getName() {
        return name;
    }

    public boolean isEqualDistance(int distance) {
        return this.distance == distance;
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
        return distance == car.distance && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
