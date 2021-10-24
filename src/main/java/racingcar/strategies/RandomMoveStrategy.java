package racingcar.strategies;

import racingcar.utils.RandomNumberUtil;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int BOUND = 9;
    private static final int MIN_VALUE = 4;

    @Override
    public boolean isMovable() {
        int number = RandomNumberUtil.getRandomNumber(BOUND);
        return number >= MIN_VALUE;
    }

}
