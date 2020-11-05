package step4.domain;

import step4.utils.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;


    @Override
    public boolean isMoved() {
        return RandomUtil.generateRandomNumber() >= MOVE_CONDITION;
    }
}
