package racingcar.model.domain;

public class RandomNumberBehavior implements CarMoveBehavior {

    private final static int MAX_RANDOM_RANGE = 10;
    private final static int MIN_BOUND_STRAIGHT = 4;
    private final static RandomNumberBehavior randomNumberBehavior;

    static {
        randomNumberBehavior = new RandomNumberBehavior();
    }

    private RandomNumberBehavior() {

    }

    public static RandomNumberBehavior getInstance() {
        return randomNumberBehavior;
    }

    private static int generateRandomNumber() {
        return (int) (Math.random() * MAX_RANDOM_RANGE);
    }

    @Override
    public boolean moveBehavior() {
        return generateRandomNumber() >= MIN_BOUND_STRAIGHT;
    }
}
