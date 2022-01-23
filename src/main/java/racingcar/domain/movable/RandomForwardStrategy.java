package racingcar.domain.movable;

public class RandomForwardStrategy implements MovableStrategy {

    private static final int STANDARD_NUMBER_OF_MOVE_FORWARD = 4;
    private static final int RANGE_OF_RANDOM_NUMBER = 10;


    @Override
    public boolean move() {
        return generateRandomNumber() >= STANDARD_NUMBER_OF_MOVE_FORWARD;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * RANGE_OF_RANDOM_NUMBER);
    }

}
