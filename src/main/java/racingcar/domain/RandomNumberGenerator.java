package racingcar.domain;

public class RandomNumberGenerator {

    private static final int RANGE_OF_RANDOM_NUMBER = 10;

    private RandomNumberGenerator() {
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * RANGE_OF_RANDOM_NUMBER);
    }

}
