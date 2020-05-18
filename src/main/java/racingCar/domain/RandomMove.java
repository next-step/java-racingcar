package racingCar.domain;

import racingCar.utils.RandomUtils;

public class RandomMove implements MoveBehavior {
    private static final int MOVABLE_MIN = 4;
    private static final int RANDOM_RANGE = 10;

    @Override
    public boolean isMove() {
        return RandomUtils.random(RANDOM_RANGE) >= MOVABLE_MIN;
    }
}
