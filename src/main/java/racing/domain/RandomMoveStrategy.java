package racing.domain;

import org.apache.commons.lang3.RandomUtils;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVABLE_MIN_NUM = 4;

    private final int min;
    private final int max;

    public RandomMoveStrategy(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean movable() {
        return RandomUtils.nextInt(min, max) >= MOVABLE_MIN_NUM;
    }
}
