package carRacing;

import java.util.Random;

public class Car {
    private static final int MOVE_STANDARD = 4;
    private static final int MAX_BOUNDS = 10;

    private int position;
    private final Random random;

    public Car(Random random) {
        this.random = random;
    }

    private boolean isMove() {
        return random.nextInt(MAX_BOUNDS) >= MOVE_STANDARD;
    }

    int go() {
        return isMove() ? ++position : position;
    }
}
