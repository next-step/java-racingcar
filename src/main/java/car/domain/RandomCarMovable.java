package car.domain;

import java.util.Random;

public class RandomCarMovable extends Movable
{

    private final int CAR_MOVING_LIMIT = 4;
    private final int CAR_MOVING_SIZE = 1;

    public RandomCarMovable() {
        this.isMovable = decideMoving();
    }

    public boolean getMovable() {
        return this.isMovable;
    }

    public int getMovingSize () {
        return CAR_MOVING_SIZE;
    }

    @Override
    public boolean decideMoving () {
        int num = new Random().nextInt(10);
        if (num >= CAR_MOVING_LIMIT) {
            return true;
        }
        return false;
    }
}
