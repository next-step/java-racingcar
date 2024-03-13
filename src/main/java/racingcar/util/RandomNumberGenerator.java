package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int MAX_NUMBER = 10;
    public static int generateRandomNumber() {
        return new Random().nextInt(MAX_NUMBER);
    }
}
