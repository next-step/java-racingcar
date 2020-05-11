package racingcar;

public class RandomCarMovingCondition implements CarMovingCondition {

    private final RandomGenerator randomGenerator;
    private final int bound;
    private final int threshold;

    public RandomCarMovingCondition(RandomGenerator randomGenerator, int bound, int threshold) {
        if (bound <= threshold) {
            throw new IllegalArgumentException("bound is more than threshold");
        }

        this.randomGenerator = randomGenerator;
        this.bound = bound;
        this.threshold = threshold;
    }

    @Override
    public boolean canMove() {
        return randomGenerator.nextInt(bound) >= threshold;
    }

    interface RandomGenerator {
        int nextInt(int bound);
    }
}
