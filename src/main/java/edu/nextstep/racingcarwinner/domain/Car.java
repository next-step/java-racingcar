/*
 * edu.nextstep.racingcarwinner.domain.Car.java
 * 0.1 2021.08.07 18:24
 * 해당 클래스의 경우 TDD, CleanCode with Java 수업의 RacingCar step4에 해당됩니다.
 */

package edu.nextstep.racingcarwinner.domain;

import java.util.Objects;
import java.util.Random;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            this.distance++;
        }
    }

    public int getRandomNum(){
        Random random = new Random();
        return random.nextInt(10);
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

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
