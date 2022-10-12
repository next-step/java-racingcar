package racing_game.domain;

import racing_game.core.Positive;

public class Car {

    private final Positive distance;

    private Car() {
        this.distance = Positive.zero();
    }

    public static Car create() {
        return new Car();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.canMove()) {
            distance.addOne();
        }
    }

    public Positive getDistance() {
        return Positive.copy(distance);
    }

    // for logging
    @Override
    public String toString() {
        return "Car{" +
            "distance=" + distance +
            '}';
    }
}
