package racingcar.strategy;

import java.util.Random;

public class RandomNumberGeneratorStrategy implements NumberGeneratorStrategy {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_RULE_MAX_NUMBER = 10;

    public int generateNumber() {
        return RANDOM.nextInt(RANDOM_RULE_MAX_NUMBER);
    }

}
