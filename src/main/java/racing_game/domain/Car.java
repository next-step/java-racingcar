package racing_game.domain;

import racing_game.core.Positive;

public class Car {

    private static final int THRESHOLD = 4;
    private final Positive distance;

    private Car() {
        this.distance = Positive.zero();
    }

    public static Car create() {
        return new Car();
    }

    public void move(int value) {
        if (canMove(value)) {
            distance.addOne();
        }
    }

    private boolean canMove(int value) {
        return value >= THRESHOLD;
    }

    public Positive getDistance() {
        return Positive.copy(distance);
    }

}
