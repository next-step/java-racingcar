package racingcar.domain.strategy;

import racingcar.utils.RandomUtils;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MINIMUM_MOVE_SIZE = 4;

    @Override
    public boolean isMove() {
        return RandomUtils.nextInt() >= MINIMUM_MOVE_SIZE;
    }
}
