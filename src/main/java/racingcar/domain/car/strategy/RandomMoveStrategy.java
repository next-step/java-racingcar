package racingcar.domain.car.strategy;

import racingcar.utils.RandomUtils;

public class RandomMoveStrategy implements CarActionStrategy {
    private final static int MAX_ACTION_NO = 9;
    private final static int MOVABLE_POINT = 4;

    public boolean isMovable() {
        return RandomUtils.getRandomPositiveInt(MAX_ACTION_NO) >= MOVABLE_POINT;
    }
}
