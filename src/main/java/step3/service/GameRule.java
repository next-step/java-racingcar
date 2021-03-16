package step3.service;

import step3.utils.RandomGenerator;
import step3.utils.RandomUtil;

public class GameRule {
    private static final int STANDARD_FOR_MOVING = 4;
    private final RandomGenerator randomGenerator;

    public GameRule() {
        randomGenerator = new RandomUtil();
    }

    public GameRule(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public boolean isMove() {
        return randomGenerator.getRandom() >= STANDARD_FOR_MOVING;
    }
}
