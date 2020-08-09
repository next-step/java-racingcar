package step3.strategy;

import step3.constant.MagicNumber;
import step3.generator.RandomGenerator;

public class RacingGameMovementStrategy implements MovementStrategy {
    private static final int RANDOM_BOUNDARY = 10;
    private static final int CONDITION_FOR_STEP_FORWARD = 4;

    @Override
    public boolean movementAction() {
        if (RandomGenerator.generateValue(RANDOM_BOUNDARY) >= CONDITION_FOR_STEP_FORWARD) {
            return true;
        }

        return false;
    }
}
