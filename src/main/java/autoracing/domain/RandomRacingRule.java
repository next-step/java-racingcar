package autoracing.domain;

public class RandomRacingRule implements RacingRule {
    static final String BAD_BOUND = "bound must be greater than zero.";
    static final String BAD_DRIVING_THRESHOLD = "drivingThreshold must be less than, or equal to bound.";

    private final int bound;
    private final int drivingThreshold;
    private final RandomIntGenerator randomIntGenerator;

    public RandomRacingRule(int bound, int drivingThreshold, RandomIntGenerator randomIntGenerator) {
        assertBoundGreaterThanZero(bound);
        assertDrivingThresholdLessThanOrEqualToBound(drivingThreshold, bound);

        this.bound = bound;
        this.drivingThreshold = drivingThreshold;
        this.randomIntGenerator = randomIntGenerator;
    }

    public RandomRacingRule(int bound, int drivingThreshold) {
        this(bound, drivingThreshold, RandomIntGenerator.DEFAULT_GENERATOR);
    }

    @Override
    public boolean canGoForward() {
        return randomIntGenerator.generate(bound) >= drivingThreshold;
    }

    private void assertBoundGreaterThanZero(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException(BAD_BOUND);
        }
    }

    private void assertDrivingThresholdLessThanOrEqualToBound(int drivingThreshold, int bound) {
        if (drivingThreshold > bound) {
            throw new IllegalArgumentException(BAD_DRIVING_THRESHOLD);
        }
    }
}
