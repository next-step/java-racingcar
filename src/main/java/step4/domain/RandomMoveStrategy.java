package step4.domain;

import step4.utils.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;


    @Override
    public boolean isMoved(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }

    @Override
    public boolean isMoved() {
        return isMoved(RandomUtil.generateRandomNumber());
    }
}
