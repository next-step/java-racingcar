package race;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private final int minMoveCondition;
    private final int maxMoveBound;

    private static final int MIN_MOVE_CONDITION = 4;
    private static final int MAX_MOVE_BOUND = 10;

    public RandomMoveStrategy() {
        this.minMoveCondition = MIN_MOVE_CONDITION;
        this.maxMoveBound = MAX_MOVE_BOUND;
    }

    public RandomMoveStrategy(int minMoveCondition, int maxMoveBound) {
        this.minMoveCondition = minMoveCondition;
        this.maxMoveBound = maxMoveBound;
    }

    @Override
    public boolean canMove() {
        return new Random().nextInt(maxMoveBound) >= minMoveCondition;
    }
}
