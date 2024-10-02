package racingGame.domain;

import java.util.Random;

public class RandomMovementCondition implements MovementCondition {
    private final int MAX_MOVE_CONDITION_VALUE = 10;
    private final int MIN_MOVE_CONDITION_VALUE = 4;
    private final Random random = new Random();

    @Override
    public boolean canMove() {
        return random.nextInt(MAX_MOVE_CONDITION_VALUE) >= MIN_MOVE_CONDITION_VALUE;
    }
}
