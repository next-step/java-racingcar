package step3.domain;

import step3.utils.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean move() {
        return RandomUtil.generateRandomNumber() >= MOVE_CONDITION;
    }
}
