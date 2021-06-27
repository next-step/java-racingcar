package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    private static final int RACING_NUMBER = 10;

    private static final Random RANDOM = new Random();

    public static int createRandomNumber() {
        return RANDOM.nextInt(RACING_NUMBER);
    }

}
