package racing.domain;

import org.apache.commons.lang3.RandomUtils;

public class RandomMoveStrategy implements MoveStrategy {

    private final int min;
    private final int max;
    private final int movableMinNum;

    public RandomMoveStrategy(int min, int max, int movableMinNum) {
        this.min = min;
        this.max = max;
        this.movableMinNum = movableMinNum;
    }

    @Override
    public boolean movable() {
        return RandomUtils.nextInt(min, max) >= movableMinNum;
    }
}
