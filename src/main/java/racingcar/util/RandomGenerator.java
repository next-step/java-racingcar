package racingcar.util;

import java.util.Random;

public class RandomGenerator {

    private static final int maxNumber = 10;

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(maxNumber);
    }
}
