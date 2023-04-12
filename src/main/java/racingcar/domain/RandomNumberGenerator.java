package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_RULE_MAX_NUMBER = 10;
    public static final int MOVABLE_NUMBER_CONDITION = 4;

    public int generate() {
        return RANDOM.nextInt(RANDOM_RULE_MAX_NUMBER);
    }

    public boolean isMovable() {
        return generate() >= MOVABLE_NUMBER_CONDITION;
    }
}
