package study.racing.model.car;

import java.util.Objects;

import study.racing.model.rule.Rule;

public class Car {

    private final String name;
    private int distance;

    public Car(String name) {
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

    public String getName() {
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
        return distance == car.distance && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
