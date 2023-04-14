package racingcar.model.car;

import racingcar.strategy.MovingStrategy;

import java.util.Objects;

public class Car {
    private final Name name;
    private final MovingStrategy movingStrategy;
    private final Distance distance;

    public Car(String name, MovingStrategy movingStrategy) {
        Objects.requireNonNull(movingStrategy, "strategy should not be null");
        this.name = new Name(name);
        this.movingStrategy = movingStrategy;
        this.distance = new Distance();
    }

    public void move() {
        int movement = movingStrategy.movement();
        this.distance.move(movement);
    }

    public String name() {
        return this.name.toString();
    }

    public Distance distance() {
        return this.distance;
    }

    public boolean isReached(Distance distance) {
        return this.distance.equals(distance);
    }
}
