package step3;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MOVE_CRITERION = 4;

    @Override
    public boolean movable() {
        return getRandomNumber() >= MOVE_CRITERION;
    }

    private int getRandomNumber() {
        return CarUtils.getNumberForMovement();
    }
}
