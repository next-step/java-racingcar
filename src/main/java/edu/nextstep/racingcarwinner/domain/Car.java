/*
 * edu.nextstep.racingcarwinner.domain.Car.java
 * 0.1 2021.08.07 18:24
 * 해당 클래스의 경우 TDD, CleanCode with Java 수업의 RacingCar step4에 해당됩니다.
 */

package edu.nextstep.racingcarwinner.domain;

import edu.nextstep.racingcarwinner.strategy.RacingStrategy;

import java.util.Objects;

public class Car {
    private final Name name;
    private Distance distance;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public void move(RacingStrategy racingStrategy) {
        if (racingStrategy.movable()) {
            this.distance = distance.move();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public int max(int maxDistance) {
        return Math.max(maxDistance, this.distance.getDistance());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName()) && Objects.equals(getDistance(), car.getDistance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDistance());
    }
}
