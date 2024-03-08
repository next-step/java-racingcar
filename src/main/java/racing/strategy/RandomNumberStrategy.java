package racing.strategy;

import racing.RandomUtil;

public class RandomNumberStrategy implements MoveStrategy {

    private static final int MOVE_STANDARD = 4;
    private static final int BOUND = 10;

    @Override
    public boolean movable() {
        return RandomUtil.randomNumber(BOUND) >= MOVE_STANDARD;
    }
}
