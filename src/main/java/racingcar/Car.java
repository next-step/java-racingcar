package racingcar;

import racingcar.Movable;

import java.util.Random;

public class Car implements Movable {
    private static final int MOVABLE_RANDOM_SEED = 10;
    private static final int MOVABLE_DECISION_FACTOR = 4;
    private final Random random = new Random();

    private int currentPosition = 0;

    @Override
    public int move() {
        if (isMovable()) {
            movePosition();
        }
        return currentPosition;
    }

    private void movePosition() {
        this.currentPosition++;
    }

    private boolean isMovable() {
        return random.nextInt(MOVABLE_RANDOM_SEED) >= MOVABLE_DECISION_FACTOR;
    }
}
