package racingcar.domain;

import racingcar.util.RandomNumberUtil;

public class MoveRule {
    private final static int RANDOM_NUMBER_BOUND = 10;
    private final static int MOVE_POINT = 4;

    public boolean isMovable() {
        return RandomNumberUtil.getRandomNumber(RANDOM_NUMBER_BOUND) >= MOVE_POINT;
    }
}
