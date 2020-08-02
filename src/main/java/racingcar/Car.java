package racingcar;

import java.util.Random;

public class Car {

    private static final Random random = new Random();
    private static final int RANDOM_RANGE = 10;
    private static final int MOVE_CONDITION = 4;

    private int moveCount = 0;

    public void moveAndStop() {

        if (isMoveCondition(random.nextInt(RANDOM_RANGE))) {
            moveCount++;
        }
    }

    private boolean isMoveCondition(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }

    public int getMoveCount() {
        return moveCount;
    }
}