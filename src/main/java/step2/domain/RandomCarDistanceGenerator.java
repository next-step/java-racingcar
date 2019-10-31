package step2.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomCarDistanceGenerator implements CarDistanceGenerator {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    private final int lowerBoundInclusive;
    private final int upperBoundExclusive;

    public RandomCarDistanceGenerator() {
        this.lowerBoundInclusive = 0;
        this.upperBoundExclusive = 10;
    }

    public RandomCarDistanceGenerator(final int lowerBoundInclusive, final int upperBoundExclusive) {
        this.lowerBoundInclusive = lowerBoundInclusive;
        this.upperBoundExclusive = upperBoundExclusive;
    }

    @Override
    public int next() {
        return random.nextInt(lowerBoundInclusive, upperBoundExclusive);
    }
}
