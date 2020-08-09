package step3.model;

import step3.strategy.MovementStrategy;
import step3.strategy.RacingGameMovementStrategy;

public class Car {
    private int distance;
    private MovementStrategy movement;

    public Car() {
        this.distance = 1;
        movement = new RacingGameMovementStrategy();
    }

    public int showDistance() {
        return distance;
    }

    public void increaseDistance() {
        this.distance++;
    }

    public void accelerateCar() {
        if (movement.movementAction()) {
            increaseDistance();
        }
    }
}
