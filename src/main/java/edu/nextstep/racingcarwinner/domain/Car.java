/*
 * edu.nextstep.racingcarwinner.domain.Car.java
 * 0.1 2021.08.07 18:24
 * 해당 클래스의 경우 TDD, CleanCode with Java 수업의 RacingCar step4에 해당됩니다.
 */

package edu.nextstep.racingcarwinner.domain;

import edu.nextstep.racingcarwinner.strategy.RacingStrategy;

import java.util.Objects;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int distance) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 필수 입니다.");
        }
        this.name = name;
        this.distance = distance;
    }

    public void move(RacingStrategy racingStrategy) {
        if (racingStrategy.movable()) {
            this.distance++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public int max(int maxDistance) {
       return Math.max(maxDistance, this.distance);
    }
}
