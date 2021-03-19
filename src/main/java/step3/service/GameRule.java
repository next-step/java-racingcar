package step3.service;

import step3.utils.NumberGenerator;

public class GameRule {
    private static final int STANDARD_FOR_MOVING = 4;
    private final NumberGenerator numberGenerator;

    public GameRule(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean isMovable() {
        return numberGenerator.getRandom() >= STANDARD_FOR_MOVING;
    }

    public boolean isMovableTest(int num) {
        return num >= STANDARD_FOR_MOVING;
    }
}
