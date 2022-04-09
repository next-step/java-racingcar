package racingcar;

import java.util.Random;

public class Car {
    private static final int includeRangeRandomNumber = 1;
    private final Random generateNumber;
    private final int rangeStartRandomNumber;
    private final int rangeEndRandomNumber;
    private final int moveCondition;
    private int moveCount;

    public Car(int rangeStartRandomNumber, int rangeEndRandomNumber, int moveCondition) {
        this.generateNumber = new Random();
        this.rangeStartRandomNumber = rangeStartRandomNumber;
        this.rangeEndRandomNumber = rangeEndRandomNumber;
        this.moveCondition = moveCondition;
    }

    public void addMoveCount() {
        if (calculateRandomNumber() >= moveCondition) {
            moveCount++;
        }
    }

    private int calculateRandomNumber() {
        return generateNumber.nextInt(rangeEndRandomNumber + includeRangeRandomNumber)
                + rangeStartRandomNumber;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
