package racingcar.service.strategy;

import racingcar.util.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;

    @Override
    public int createMoveNumber() {
        return RandomUtil.pickNumberInRange(RANDOM_START, RANDOM_END);
    }
}
