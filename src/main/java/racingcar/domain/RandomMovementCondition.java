package racingcar.domain;

import java.util.Random;

public class RandomMovementCondition implements MovementCondition {
    private static final int MAX_NUMBER = 10;

    private Random random = new Random();
    private int moveThreshold;

    public RandomMovementCondition(int moveThreshold) {
        this.moveThreshold = moveThreshold;
    }

    @Override
    public boolean isMovable() {
        if (random.nextInt(MAX_NUMBER) < moveThreshold) {
            return false;
        }
        return true;
    }
}
