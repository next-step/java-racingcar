package racingcar;

import utils.RandomUtils;

public class RandomRacingCarMoveStrategy implements RacingCarMoveStrategy {

    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        int min = 0;
        int max = 9;
        return RandomUtils.random(min, max) >= MOVE_THRESHOLD;
    }
}
