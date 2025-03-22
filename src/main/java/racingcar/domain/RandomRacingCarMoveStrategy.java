package racingcar.domain;

import utils.RandomUtils;

public class RandomRacingCarMoveStrategy implements RacingCarMoveStrategy {

    private final RandomUtils randomUtils;

    public RandomRacingCarMoveStrategy(RandomUtils randomUtils) {
        this.randomUtils = randomUtils;
    }

    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        int min = 0;
        int max = 9;
        return randomUtils.random(min, max) >= MOVE_THRESHOLD;
    }
}
