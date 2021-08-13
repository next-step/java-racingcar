package racingcar.util;

import java.util.Random;

public class RandomGenerator {
    public static int getRandomNumber(int randomNumberRange) {
        return new Random().nextInt(randomNumberRange);
    }
}
