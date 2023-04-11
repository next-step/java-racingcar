package study.carrace.step3.domain;

public class RandomMoveStrategy implements MoveStrategy {
    private final RandomIntegerGenerator randomIntegerGenerator;
    private final int movableThreshold;

    public RandomMoveStrategy(RandomIntegerGenerator randomIntegerGenerator, int movableThreshold) {
        this.randomIntegerGenerator = randomIntegerGenerator;
        this.movableThreshold = movableThreshold;
    }

    @Override
    public boolean moveOrStop() {
        return randomIntegerGenerator.generate() >= movableThreshold;
    }
}
