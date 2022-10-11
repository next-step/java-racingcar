package racinggame.domain.strategy;

import racinggame.util.RandomUtils;

import java.util.function.IntFunction;

public class RandomMoveStrategy implements MoveStrategy {

    public static final int MAX_RANDOM_NUMBER = 10;
    public static final IntFunction<Integer> DEFAULT_GENERATE_STRATEGY = (randomNumber) -> RandomUtils.randomNumber(randomNumber);

    private static final int CAN_MOVE_MIN_NUMBER = 4;

    private final IntFunction<Integer> numberGenerateStrategy;

    public RandomMoveStrategy(IntFunction<Integer> numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    @Override
    public boolean movable() {
        return numberGenerateStrategy.apply(MAX_RANDOM_NUMBER) >= CAN_MOVE_MIN_NUMBER;
    }
}
