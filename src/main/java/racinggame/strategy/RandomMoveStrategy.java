package racinggame.strategy;

import racinggame.util.RandomNumber;

public final class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVABLE_NUMBER = 4;

    public RandomMoveStrategy() {
    }

    @Override
    public boolean movable() {
        return RandomNumber.generate(0, 10) >= MOVABLE_NUMBER;
    }

}
