package racingcar.util;

import java.util.Random;

public class RandomGenerator {

    public int generateRandomNumber() {
        private static final int maxNumber = 10;
        Random random = new Random();
        return random.nextInt(maxNumber);
    }
}
