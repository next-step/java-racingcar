package step3to5.utils;

public class GameRule {
    private static final int STANDARD_FOR_MOVING = 4;
    private final NumberGenerator numberGenerator;

    public GameRule(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean isMovable() {
        return numberGenerator.getRandom() >= STANDARD_FOR_MOVING;
    }
}
