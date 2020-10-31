package step3.domain;

import step3.utils.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;
    private static RandomUtil randomUtil;

    public RandomMoveStrategy() {
        randomUtil = new RandomUtil();
    }

    @Override
    public boolean move() {
        return randomUtil.generateRandomNumber() >= MOVE_CONDITION;
    }
}
