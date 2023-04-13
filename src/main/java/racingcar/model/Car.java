package racingcar.model;

import racingcar.strategy.MovingStrategy;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final MovingStrategy movingStrategy;
    private int distance = 0;

    public Car(String name, MovingStrategy movingStrategy) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Car name cannot be null or empty:" + name);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            String message = String.format("Car name cannot exceed %s character: %s", MAX_NAME_LENGTH, name);
            throw new IllegalArgumentException(message);
        }

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

    public boolean isReached(int distance) {
        return this.distance == distance;
    }
}
