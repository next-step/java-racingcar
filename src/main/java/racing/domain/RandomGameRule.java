package racing.domain;

import java.util.Random;

public class RandomGameRule implements GameRule {
    private static final int RANDOM_BOUND_ZERO_TO_NINE = 10;
    private static final int RUN_CRITERIA_MIN_RESULT = 4;
    private static final Random RANDOM = new Random();

    @Override
    public boolean isPassedCondition() {
        return RANDOM.nextInt(RANDOM_BOUND_ZERO_TO_NINE) >= RUN_CRITERIA_MIN_RESULT;
    }
}
