package step5.model;

import step5.streategy.MovementStrategy;

public class Car {
    private final String name;
    private int distance;

    public Car(String john) {
        this.name = john;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void goForward() {
        this.distance++;
    }

    public void moveWithStrategy(MovementStrategy movementStrategy) {
        if (movementStrategy.isMovingCar()) {
            goForward();
        }
    }
}
