package car.util;

public final class RandomCarMovable extends Movable {

    private final static int CAR_MOVING_LIMIT = 4;
    private final static int CAR_MOVING_SIZE = 1;
    private final static int ZERO = 0;

    public RandomCarMovable() {
    }

    @Override
    public int decideMoving(int movingSpeed) {
        if (movingSpeed >= CAR_MOVING_LIMIT) {
            return CAR_MOVING_SIZE;
        }
        return ZERO;
    }

    @Override
    public int decideMoving() {
        int movingSpeed = NumberGenerator.getRandomNumber();
        return this.decideMoving(movingSpeed);
    }
}
