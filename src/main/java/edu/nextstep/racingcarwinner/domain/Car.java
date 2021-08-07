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

    public void move() {
        if (getRandomNum() >= 4) {
            this.distance++;
        }
    }

    protected int getRandomNum(){
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
