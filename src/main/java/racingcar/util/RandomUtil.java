package racingcar.util;

import java.util.Random;

public class RandomUtil {
    public static int generateRandomValue(int lowerBound, int highBound) {
        return new Random().nextInt(highBound - lowerBound) + lowerBound;
    }
}
