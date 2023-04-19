package racing.rule;

import java.util.Random;

public class RandomRacingRule implements RacingRule{

    public static final int DEFAULT_BOUND = 10;
    private final Random random;

    public RandomRacingRule() {
        random = new Random();
    }

    @Override
    public int generateNumber() {
        return random.nextInt(DEFAULT_BOUND);
    }
}
