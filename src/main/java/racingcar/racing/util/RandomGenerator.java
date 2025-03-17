package racingcar.racing.util;

import java.util.Random;

public class RandomGenerator {
    private final static Random RANDOM = new Random();

    public int generateRandomNumber(int max) {
        return RANDOM.nextInt(max);
    }
}
