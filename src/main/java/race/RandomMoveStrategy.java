package race;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private final int minMoveCondition;
    private final int maxMoveBound;

    public RandomMoveStrategy(int minMoveCondition, int maxMoveBound) {
        this.minMoveCondition = minMoveCondition;
        this.maxMoveBound = maxMoveBound;
    }

    @Override
    public boolean canMove() {
        return new Random().nextInt(maxMoveBound) >= minMoveCondition;
    }
}
