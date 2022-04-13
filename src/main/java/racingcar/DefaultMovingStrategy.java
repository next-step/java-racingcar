package racingcar;

public class DefaultMovingStrategy implements MovingStrategy {

    private static final int MINIMUM_NUMBER_FOR_MOVEMENT = 4;

    @Override
    public boolean isMovable(int input) {
        return input > MINIMUM_NUMBER_FOR_MOVEMENT;
    }
}
