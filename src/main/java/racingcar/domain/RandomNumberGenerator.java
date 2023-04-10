package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int RANDOM_RULE_NUMBER = 10;

    private final static Random random = new Random();

    public int generate() {
        return random.nextInt(RANDOM_RULE_NUMBER);
    }
}
