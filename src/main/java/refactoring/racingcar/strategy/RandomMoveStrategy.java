package refactoring.racingcar.strategy;

public class RandomMoveStrategy implements MoveStrategy {
    private final RandomStrategy randomStrategy;
    private final int threshold;

    public RandomMoveStrategy(RandomStrategy randomStrategy, int threshold) {
        this.randomStrategy = randomStrategy;
        this.threshold = threshold;
    }

    @Override
    public boolean shouldMove() {
        return randomStrategy.getOne() >= threshold;
    }
}
