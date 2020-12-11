package carrace.domain;

import java.util.Random;

public class RandomRacingRule implements RacingRule {
    private static final Random random = new Random();

    private static final int MAX_RANGE = 9;

    @Override
    public int generateNumber() {
        return random.nextInt(MAX_RANGE);
    }
}
