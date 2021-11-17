package study.racing.domain.car;

import java.util.Objects;

import study.racing.domain.Distance;
import study.racing.domain.Name;
import study.racing.domain.rule.Rule;

public class Car {

    private final Name name;
    private Distance distance;

    public Car(Name name) {
        this.name = name;
        distance = Distance.init();
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
