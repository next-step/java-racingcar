package racinggame.domain.strategy;

import racinggame.util.RandomUtils;

import java.util.function.IntFunction;
import java.util.function.Supplier;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int CAN_MOVE_MIN_NUMBER = 4;
    public static final int MAX_RANDOM_NUMBER = 10;

    private final IntFunction<Integer> numberGenerateStrategy;

    public RandomMoveStrategy(IntFunction<Integer> numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    @Override
    public boolean movable() {
        return numberGenerateStrategy.apply(MAX_RANDOM_NUMBER) >= CAN_MOVE_MIN_NUMBER;
    }
}
