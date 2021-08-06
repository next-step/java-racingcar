package racingcar.util;

import java.util.Random;

public class RandomGenerator {
    public static int getRandomNumber(int range) {
        return new Random().nextInt(range);
    }
}
