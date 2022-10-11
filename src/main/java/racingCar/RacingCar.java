package racingCar;

import java.util.Random;

public class RacingCar {

    private static final int NUM_RANGE = 10;
    private static final int MOVEABLE_MINIMUM = 4;

    Random random = new Random();
    private int distance;

    public RacingCar() {}

    public RacingCar(int distance) {
        this.distance = distance;
    }

    public int distance() {
        return distance;
    }

    private boolean canMove() {
        return random.nextInt(NUM_RANGE) >= MOVEABLE_MINIMUM;
    }

    private void move() {
        distance++;
    }

    public void race() {
        if (canMove()) {
            move();
        }
    }
}
