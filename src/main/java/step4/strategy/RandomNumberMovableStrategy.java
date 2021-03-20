package step4.strategy;

import step4.utils.RandomUtils;

public class RandomNumberMovableStrategy implements MovableStrategy {
    private static final int MAX_BOUND = 10;
    private static final int FORWARD_NUM = 4;

    @Override
    public boolean movable() {
        if (RandomUtils.getRandomNum(MAX_BOUND) >= FORWARD_NUM) {
            return true;
        }
        return false;
    }
}
