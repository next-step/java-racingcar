package study.racing.model.car;

import java.util.Objects;

import study.racing.model.Distance;
import study.racing.model.Name;
import study.racing.model.rule.Rule;

public class Car {

    private final Name name;
    private Distance distance;

    public Car(Name name) {
        this.name = name;
        this.distance = Distance.init();
    }

    public void moveOrStop(Rule rule) {
        if (rule.isFollowRule()) {
            move();
        }
    }

    private void move() {
        distance.increase();
    }

    public Distance getDistance() {
        return distance;
    }

    public Name getName() {
        return name;
    }

    public boolean isEqualDistance(Distance distance) {
        return this.distance.equals(distance);
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
