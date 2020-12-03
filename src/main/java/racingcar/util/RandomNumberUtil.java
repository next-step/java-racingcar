package racingcar.util;

import java.util.Random;

public class RandomNumberUtil {
    public static int getRandomNumber(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}
