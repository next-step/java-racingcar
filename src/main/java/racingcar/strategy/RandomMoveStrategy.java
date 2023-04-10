package racingcar.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private final RandomStrategy randomStrategy;
    private final Random random;
    private final int threshold;

    public RandomMoveStrategy(RandomStrategy randomStrategy, int threshold) {
        this.randomStrategy = randomStrategy;
        this.random = new Random();
        this.threshold = threshold;
    }

    @Override
    public boolean shouldMove() {
        return randomStrategy.getOne() >= threshold;
    }
}
