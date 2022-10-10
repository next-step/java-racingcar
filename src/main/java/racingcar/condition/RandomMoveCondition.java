package racingcar.condition;

import racingcar.util.RandomGenerator;

public class RandomMoveCondition implements MoveCondition {
    private static final int MINIMUM_OF_MOVE = 4;

    public RandomMoveCondition() {}

    @Override
    public boolean isMovable() {
        return MINIMUM_OF_MOVE <= RandomGenerator.randomInt();
    }
}
