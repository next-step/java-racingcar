package racingcar.strategy;

import java.util.Random;

public class RandomNumberGeneratorStrategy implements NumberGeneratorStrategy {
    private static final int RANDOM_RULE_MAX_NUMBER = 10;
    public static final int MOVABLE_NUMBER_CONDITION = 4;
    private static final Random RANDOM = new Random();

    public int generateNumber() {
        return RANDOM.nextInt(RANDOM_RULE_MAX_NUMBER);
    }

    @Override
    public boolean isMovable(int number) {
        return number >= MOVABLE_NUMBER_CONDITION;
    }
}
