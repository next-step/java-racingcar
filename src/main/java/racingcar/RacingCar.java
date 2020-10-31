package racingcar;

import java.util.Random;

public class RacingCar {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_BOUND = 10;
    private static final int MIN_MOVABLE_NUM = 4;

    private final int numberOfCountToTry;
    private int moveCount;

    public RacingCar(int numberOfCountToTry) {
        this.numberOfCountToTry = numberOfCountToTry;
        moveCount = 0;
    }

    public void tryToMove() {
        int i = RANDOM.nextInt(RANDOM_BOUND);

        if (moveCount >= numberOfCountToTry) {
            return;
        }

        if (i >= MIN_MOVABLE_NUM) {
            moveCount++;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }
}
