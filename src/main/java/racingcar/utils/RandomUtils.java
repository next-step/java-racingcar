package racingcar.utils;

import java.util.Random;

public class RandomUtils {
    public static int getRandomPositiveInt(int max) {
        return new Random().nextInt(max + 1);
    }
}
