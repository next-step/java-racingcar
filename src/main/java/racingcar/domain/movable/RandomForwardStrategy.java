package racingcar.domain.movable;

public class RandomForwardStrategy implements MovableStrategy {

    private static final int STANDARD_NUMBER_OF_MOVE_FORWARD = 4;
    private static final int RANGE_OF_RANDOM_NUMBER = 10;

    @Override
    public boolean move(final int randomNumber) {
        return randomNumber >= STANDARD_NUMBER_OF_MOVE_FORWARD;
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * RANGE_OF_RANDOM_NUMBER);
    }

}
