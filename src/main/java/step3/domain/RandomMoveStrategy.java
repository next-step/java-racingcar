package step3.domain;

import step3.util.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {

    private final int bound;
    private final int limit;

    public RandomMoveStrategy(int bound, int limit) {
        this.bound = bound;
        this.limit = limit;
    }

    @Override
    public boolean isMove() {
        return RandomUtil.nextInt(bound) >= limit;
    }
}
