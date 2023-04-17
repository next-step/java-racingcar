package racingcar.domain;

import racingcar.generator.NumberGenerator;

public class Car {
    public static final int CAR_MOVABLE_LOWER_BOUND = 4;

    private int movementCount = 0;

    public int getMovementCount() {
        return movementCount;
    }

    public void move(NumberGenerator numberGenerator) {
        final int number = numberGenerator.generator();

        if (number >= CAR_MOVABLE_LOWER_BOUND) {
            movementCount += 1;
        }
    }
}
