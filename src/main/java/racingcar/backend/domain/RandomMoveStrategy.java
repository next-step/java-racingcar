package racingcar.backend.domain;

import racingcar.backend.utils.RandomUtils;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVING_CONDITION_MIN_VALUE = 4;
    private int randomNumber;

    public RandomMoveStrategy() {
        this.randomNumber = RandomUtils.generate();
    }

    @Override
    public boolean movable() {
        return MOVING_CONDITION_MIN_VALUE <= randomNumber;
    }
}
