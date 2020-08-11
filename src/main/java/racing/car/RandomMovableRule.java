package racing.car;

import racing.util.RandomUtil;

public class RandomMovableRule implements MovableRule {

    public static final int RANDOM_BOUND = 10;
    public static final int RANDOM_STANDARD = 4;

    @Override
    public boolean isMovable() {
        return RandomUtil.randomInt(RANDOM_BOUND) >= RANDOM_STANDARD;
    }

}
