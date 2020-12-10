package step3.model;

import step3.RandomNumberProvider;

public class RandomMovingStrategy implements MovingStrategy {
    private final int MOVEMENT_CONDITION;
    private final int MOVEMENT_DISTANCE;

    public RandomMovingStrategy(int movementCondition, int movementDistance) {
        this.MOVEMENT_CONDITION = movementCondition;
        this.MOVEMENT_DISTANCE = movementDistance;
    }

    @Override
    public int move() {
        if (isMovable(RandomNumberProvider.provideRandomNumber())) {
            return MOVEMENT_DISTANCE;
        }
        return 0;
    }

    private boolean isMovable(int number) {
        return number > MOVEMENT_CONDITION;
    }
}
