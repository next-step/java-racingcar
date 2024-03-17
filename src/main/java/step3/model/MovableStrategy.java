package step3.model;

import step3.common.NumberGenerator;

public class MovableStrategy {
    private static final int MOVE_CONDITION = 4;
    private NumberGenerator numberGenerator;

    public MovableStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean movable() {
        return numberGenerator.generate() >= MOVE_CONDITION;
    }
}
