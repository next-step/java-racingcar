package autoracing;

import java.util.Random;

public class RandomRacingRule implements RacingRule {
    private static final Random RANDOM = new Random();
    static final String BAD_BOUND = "bound must be greater than zero.";
    static final String BAD_DRIVING_THRESHOLD = "drivingThreshold must be less than, or equal to bound.";

    private final int bound;
    private final int drivingThreshold;

    public RandomRacingRule(int bound, int drivingThreshold) {
        if (bound <= 0) {
            throw new IllegalArgumentException(BAD_BOUND);
        }
        if (drivingThreshold > bound) {
            throw new IllegalArgumentException(BAD_DRIVING_THRESHOLD);
        }
        this.bound = bound;
        this.drivingThreshold = drivingThreshold;
    }

    @Override
    public boolean canGoForward() {
        return RANDOM.nextInt(bound) >= drivingThreshold;
    }
}
