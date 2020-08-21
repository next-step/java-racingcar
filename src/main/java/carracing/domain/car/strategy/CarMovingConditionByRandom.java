package carracing.domain.car.strategy;

import java.util.Random;

public class CarMovingConditionByRandom implements CarMovingCondition {

    private static final int MOVE_POSITION = 4;

    public int getPower() {
        Random random = new Random();
        return random.nextInt(10);
    }

    @Override
    public boolean isMovable() {
        return getPower() >= MOVE_POSITION;
    }
}
