package racing;

import java.util.Random;

public class RandomNumberConditionStrategy implements ForwardConditionStrategy {
    private static final RandomNumberConditionStrategy STRATEGY = new RandomNumberConditionStrategy();

    private final RandomNumberGenerator generator = new RandomNumberGenerator();

    private RandomNumberConditionStrategy() {
    }

    public static RandomNumberConditionStrategy getInstance() {
        return STRATEGY;
    }

    @Override
    public boolean judgeCondition() {
        return !(generator.generate() >= 4);
    }

    int generateUpToTen(){
        return generator.generate();
    }

    private class RandomNumberGenerator {
        private static final int BOUND = 10;

        private final Random random = new Random();

        private RandomNumberGenerator() {
        }

        private int generate() {
            return random.nextInt(BOUND);
        }
    }
}
