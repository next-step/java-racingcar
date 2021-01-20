package racingcar;

import java.util.Random;

public class MoveChecker {
    private final int UPPER_BOUND = 10;
    private final int THRESHOLD = 4;

    private static final Random randomGenerator = new Random();

    public boolean isMoving() {
        int randNum = randomGenerator.nextInt(UPPER_BOUND);
        return randNum >= THRESHOLD;
    }
}