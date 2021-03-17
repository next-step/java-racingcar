package step3.service;

import step3.utils.NumberGenerator;
import step3.utils.RandomUtil;

public class GameRule {
    private static final int STANDARD_FOR_MOVING = 4;
    private final NumberGenerator numberGenerator;

    public GameRule() {
        numberGenerator = new RandomUtil();
    }

    public boolean isMovable() {
        return numberGenerator.getRandom() >= STANDARD_FOR_MOVING;
    }
}
