package racingcar.domain.movable;

public class RandomForwardStrategy implements MovableStrategy {

    private static final int STANDARD_NUMBER_OF_MOVE_FORWARD = 4;

    @Override
    public boolean move(final int randomNumber) {
        return randomNumber >= STANDARD_NUMBER_OF_MOVE_FORWARD;
    }

}
