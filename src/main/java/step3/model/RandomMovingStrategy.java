package step3.model;

import step3.RandomNumberProvider;

public class RandomMovingStrategy implements MovingStrategy {
    private final int MOVEMENT_CONDITION = 3;
    private final int MOVEMENT_DISTANCE = 1;

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
