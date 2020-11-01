package step03.strategy;

import step03.RandomGenerator;

public class RandomMoveStrategy implements MoveStrategy {
    private final int standard;
    private final int max;

    private RandomMoveStrategy(int standard, int max) {
        this.standard = standard;
        this.max = max;
    }

    public static RandomMoveStrategy of(int standard, int max) {
        return new RandomMoveStrategy(standard, max);
    }

    public static RandomMoveStrategy of() {
        return of(4, 9);
    }

    @Override
    public boolean isGoing() {
        final int randomValue = RandomGenerator.ZeroToPositiveIntGenerate(max);
        return randomValue >= standard;
    }
}
