package racingcar.backend.domain;

import racingcar.backend.utils.RandomUtils;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVING_CONDITION_MIN_VALUE = 4;

    @Override
    public boolean movable() {
        return MOVING_CONDITION_MIN_VALUE <= RandomUtils.generate();
    }
}
