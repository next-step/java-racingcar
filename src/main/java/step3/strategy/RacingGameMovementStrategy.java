package step3.strategy;

import step3.constant.MagicNumber;
import step3.generator.RandomGenerator;

public class RacingGameMovementStrategy implements MovementStrategy {
    @Override
    public boolean movementAction() {
        if (RandomGenerator.generateValue() >= MagicNumber.CONDITION_FOR_STEP_FORWARD) {
            return true;
        }

        return false;
    }
}
