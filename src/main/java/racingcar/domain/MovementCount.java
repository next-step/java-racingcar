package racingcar.domain;

import racingcar.generator.NumberGenerator;

public class MovementCount {
    public static final int CAR_MOVABLE_LOWER_BOUND = 4;
    private int movementCount = 0;

    public MovementCount() {
    }

    public MovementCount(int movementCount) {
        this.movementCount = movementCount;
    }

    public int getMovementCount() {
        return movementCount;
    }

    public void move(NumberGenerator numberGenerator) {
        final int number = numberGenerator.generator();

        if (number >= CAR_MOVABLE_LOWER_BOUND) {
            movementCount += 1;
        }
    }

    public boolean isWinnerMovementCount(int movementCount) {
        return this.movementCount == movementCount;
    }
}
