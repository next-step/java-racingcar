package racingcar.model;

import racingcar.strategy.MovingStrategy;

public class Car {
    private final MovingStrategy movingStrategy;
    private final String name;
    private int distance = 0;

    public Car(String name, MovingStrategy movingStrategy) {
        this.name = name;
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        int movement = movingStrategy.movement();
        this.distance += movement;
    }

    public String name() {
        return this.name;
    }

    public int distance() {
        return this.distance;
    }
}
