package racingcar.domain.strategy;

import racingcar.util.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final int THRESHOLD = 4;

    @Override
    public boolean isMoveable() {
        int randomNum = RandomUtil.pickNumberInRange(RANDOM_START, RANDOM_END);
        return THRESHOLD < randomNum;
    }
}
