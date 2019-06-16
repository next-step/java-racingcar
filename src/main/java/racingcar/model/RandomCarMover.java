package racingcar.model;

import racingcar.util.RandomUtils;

public class RandomCarMover extends CarMover {

    static final int MOVING_CONDITION = 4;
    static final int RANDOM_LIMIT = 10;
    private static RandomUtils randomUtils = new RandomUtils();

    @Override
    protected boolean isMove() {
        return MOVING_CONDITION >= randomUtils.getInt(RANDOM_LIMIT);
    }
}