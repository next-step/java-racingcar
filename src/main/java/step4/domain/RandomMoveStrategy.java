package step4.domain;

import step4.utils.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;


    private RandomMoveStrategy(){}
    @Override
    public boolean move() {
        return RandomUtil.generateRandomNumber() >= MOVE_CONDITION;
    }
}
