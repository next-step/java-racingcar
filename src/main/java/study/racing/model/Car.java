package study.racing.model;

import java.util.Random;

public class Car implements Comparable<Car> {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.getPosition();
    }
}
