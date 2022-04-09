package racingcar;

import java.util.Random;

public class Car {
    private static final int includeRangeRandomNumber = 1;
    private final Random generateNumber;
    private final int rangeStartRandomNumber;
    private final int rangeEndRandomNumber;
    private final int moveCondition;
    private int moveCount;

    private Car(Builder builder) {
        this.generateNumber = new Random();
        this.rangeStartRandomNumber = builder.rangeStartRandomNumber;
        this.rangeEndRandomNumber = builder.rangeEndRandomNumber;
        this.moveCondition = builder.moveCondition;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private int rangeStartRandomNumber;
        private int rangeEndRandomNumber;
        private int moveCondition;

        public Builder rangeStartRandomNumber(int rangeStartRandomNumber) {
            this.rangeStartRandomNumber = rangeStartRandomNumber;
            return this;
        }

        public Builder rangeEndRandomNumber(int rangeEndRandomNumber) {
            this.rangeEndRandomNumber = rangeEndRandomNumber;
            return this;
        }

        public Builder moveCondition(int moveCondition) {
            this.moveCondition = moveCondition;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
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
