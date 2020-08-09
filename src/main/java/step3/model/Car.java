package step3.model;

import step3.strategy.MovementStrategy;

public class Car {
    private int distance;
    private MovementStrategy movement;

    public Car() {
        this.distance = 1;
    }

    public Car(int initaialDistance, MovementStrategy strategy) {
        this.distance = initaialDistance;
        this.movement = strategy;
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
