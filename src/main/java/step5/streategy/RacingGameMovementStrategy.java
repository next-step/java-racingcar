package step5.streategy;

import step5.generator.RandomGenerator;

public class RacingGameMovementStrategy implements MovementStrategy {
    public static final int MAXIMUM_BOUNDARY = 10;
    public static final int RANDOM_CONDITION = 4;

    @Override
    public boolean isMovingCar() {
        if (RandomGenerator.generateValue(MAXIMUM_BOUNDARY) >= RANDOM_CONDITION) {
            return true;
        }
        return false;
    }
}
