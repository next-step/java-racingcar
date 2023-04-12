package racingcar.model;

import racingcar.strategy.MovingStrategy;

public class Car {
    private final MovingStrategy movingStrategy;
    private int distance = 0;

    public Car(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        int movement = movingStrategy.movement();
        this.distance += movement;
    }

    public int distance() {
        return this.distance;
    }
}
