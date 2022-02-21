package racingcar.domain;

public class RandomNumberGenerator {

    private static final int MAX_NUMBER = 10;

    public static int getRandomNumber() {
        return (int) Math.floor(Math.random() * MAX_NUMBER);
    }
}
